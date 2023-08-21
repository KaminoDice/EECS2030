	public static String encrypt(String textToEncrypt, String key) {
		String substitutionPattern;
		int [] unityTranspositionPattern = {0, 1, 2, 3, 4, 5, 6, 7};
		int [] transpositionPattern;

		int hash = key.hashCode();
		random.setSeed(hash);
		substitutionPattern = shuffleString(ALPHABET, random, 100);
		random.setSeed(hash);
		transpositionPattern = shuffleInts(unityTranspositionPattern, random, 100);

		String string = textToEncrypt.toUpperCase();
		String substituted, transposed;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < string.length(); i += 64)
		{
			int endIndex = i + 64 <= string.length() ? i + 64 : string.length(); 
			String block = string.substring(i, endIndex);
			if (block.length() < 64) block = String.format("%-64s", block);
			substituted = applySubstitution(block, ALPHABET, substitutionPattern);
			transposed = applyTransposition(substituted, transpositionPattern);
			result.append(transposed);
		}
		return result.toString();
	}

	private static String shuffleString(String string, Random random, int rounds)
	{
		StringBuffer result = 
				new StringBuffer(string);
		for (int i = 0; i < rounds; i++){
			int randomPosition1 = random.nextInt(string.length());
			int randomPosition2 = random.nextInt(string.length());
			//swap items at randomPosition1 and randomPosition2
			char temp = result.charAt(randomPosition1);
			result.setCharAt(randomPosition1, 
					result.charAt(randomPosition2));
			result.setCharAt(randomPosition2, temp);
		}
		return result.toString();
	}

	private static int[] shuffleInts(int[] pattern, Random random, int rounds) {
		int[] result = pattern.clone();
		for (int i = 0; i < rounds; i++)
		{
			int randomPosition1 = random.nextInt(result.length);
			int randomPosition2 = random.nextInt(result.length);
			//swap items at randomPosition1 and randomPosition2
			int temp = result[randomPosition1];
			result[randomPosition1] = result[randomPosition2];
			result[randomPosition2] = temp;
		}
		return result;
	}


	/**
	 * @param input input to encrypt
	 * @param from these letters will be substituted
	 * @param to letters will be substituted with these
	 * @return
	 */
	private static String applySubstitution(String input, String from, String to)
	{
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < input.length(); i++)
		{
			int index;
			index = from.indexOf(input.charAt(i));
			if (index != -1 )
				buffer.append(to.charAt(index));
			//if the symbol is not found, substitute with the one corresponding to SPACE
			else buffer.append(to.charAt(from.indexOf(" ")));
		}
		return buffer.toString();
	}

	/**
	 * Write chars into an 8x8 matrix row-by-row, 
	 * read column-by-column in specified order
	 * @param input 64 char string
	 * @param columnOrder order in which to read columns
	 * @return transposed and reordered rows
	 */
	private static String applyTransposition(String input, int [] columnOrder)
	{
		StringBuffer buffer = new StringBuffer();
		char [][] matrix = new char [TRANSP_MATRIX_SIZE][TRANSP_MATRIX_SIZE];

		for (int row = 0, index = 0; row < matrix.length; row++)
			for (int column = 0; column < matrix[row].length; column ++, index ++)
				if (index < input.length())
					matrix[row][column] = input.charAt(index);
				else matrix[row][column] = ' ';
		
		for (int i = 0, column = columnOrder[0]; i < TRANSP_MATRIX_SIZE; i++)
		{
			column = columnOrder[i];
			for (int row = 0; row < TRANSP_MATRIX_SIZE; row++)
				buffer.append(matrix[row][column]);
		}

		return buffer.toString();
	}
	

