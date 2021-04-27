class Position {
	private int line;
	private int column;

	/**
	 * 
	 */
	public Position() {
	}

	/**
	 * @param l: int
	 * @param t: int
	 */
	public Position(int l, int t) {
		line = l;
		column = t;
	}

	/**
	 * @param p: Position
	 */
	public Position(Position p) {
		line = p.line;
		column = p.column;
	}

	/**
	 * @param p: Position
	 */
	public void set(Position p) {
		line = p.line;
		column = p.column;
	}

	/**
	 * @param l: Position
	 * @return boolean
	 */
	public boolean equals(Position l) {
		return l.line == line && l.column == column;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[ligne:"+ Integer.toString(line+1) + ", colonne:" + Integer.toString(column+1) + ']';
	}

	/**
	 * @return int
	 */
	public int getLine() {
		return line;
	}

	/**
	 * @return int
	 */
	public int getColumn() {
		return column;
	}

}
