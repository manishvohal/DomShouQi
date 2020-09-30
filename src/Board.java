/**
 * @brief Board (Model in M-V-C)
 *
 * rule book:
 *   use this initial setup.
 *   http://veryspecial.us/free-downloads/AncientChess.com-DouShouQi.pdf
 *
 * video of game play & nice picture of initial board setup:
 *   use this (same as above) initial setup.
 *   http://ancientchess.com/page/play-doushouqi.htm
 *
 * play online:
 *   But do NOT use this setup!  Dog and wolf are interchanged.
 *   http://liacs.leidenuniv.nl/~visjk/doushouqi/
 *   Note: Dog and wolf are in different positions.
 *
 * Copyright © George J. Grevera, 2016. All rights reserved.
 */
public class Board {

    /// constants for the size of the board
    public static final int   fRows = 9;  ///< # of board rows
    public static final int   fCols = 7;  ///< # of board cols

    /// the (underlying) playing board. board[0][0] is the upper left corner.
    protected Base  board[][] = new Base[ fRows ][ fCols ];

    /// the noveable pieces on the playing board. board[0][0] is the upper left corner.
    protected Piece piece[][] = new Piece[ fRows ][ fCols ];

    protected boolean  bluesTurn = true;  ///< by convention, blue goes first
    //-----------------------------------------------------------------------
    /** @brief init the board.
     *
     *  by convention, red will initially be in the top half (0,0) of the
     *  board, and blue will start in the bottom half. be careful. the
     *  opposite sides do not mirror each other!
     *  @todo v1
     */
    public Board ( ) {
        //init the underlying board
        //Red base
        this.board[0][2] = Base.cRTrap;
        this.board[0][3] = Base.cRDen;
        this.board[0][4] = Base.cRTrap;
        this.board[1][3] = Base.cRTrap;

        //Water squares
        this.board[3][1] = Base.cWater;
        this.board[3][2] = Base.cWater;
        this.board[3][4] = Base.cWater;
        this.board[3][5] = Base.cWater;
        this.board[4][1] = Base.cWater;
        this.board[4][2] = Base.cWater;
        this.board[4][4] = Base.cWater;
        this.board[4][5] = Base.cWater;
        this.board[5][1] = Base.cWater;
        this.board[5][2] = Base.cWater;
        this.board[5][4] = Base.cWater;
        this.board[5][5] = Base.cWater;

        //Blue base
        this.board[8][2] = Base.cBTrap;
        this.board[8][4] = Base.cBTrap;
        this.board[8][3] = Base.cBDen;
        this.board[7][3] = Base.cBTrap;

        //Ground squares
        this.board[0][0] = Base.cGround;
        this.board[0][1] = Base.cGround;
        this.board[0][2] = Base.cGround;
        this.board[0][3] = Base.cGround;
        this.board[0][4] = Base.cGround;
        this.board[0][5] = Base.cGround;
        this.board[0][6] = Base.cGround;
        this.board[1][0] = Base.cGround;
        this.board[1][1] = Base.cGround;
        this.board[1][2] = Base.cGround;
        this.board[1][3] = Base.cGround;
        this.board[1][4] = Base.cGround;
        this.board[1][5] = Base.cGround;
        this.board[1][6] = Base.cGround;
        this.board[2][0] = Base.cGround;
        this.board[2][1] = Base.cGround;
        this.board[2][2] = Base.cGround;
        this.board[2][3] = Base.cGround;
        this.board[2][4] = Base.cGround;
        this.board[2][5] = Base.cGround;
        this.board[2][6] = Base.cGround;

        this.board[6][0] = Base.cGround;
        this.board[6][1] = Base.cGround;
        this.board[6][2] = Base.cGround;
        this.board[6][3] = Base.cGround;
        this.board[6][4] = Base.cGround;
        this.board[6][5] = Base.cGround;
        this.board[6][6] = Base.cGround;
        this.board[7][0] = Base.cGround;
        this.board[7][1] = Base.cGround;
        this.board[7][2] = Base.cGround;
        this.board[7][3] = Base.cGround;
        this.board[7][4] = Base.cGround;
        this.board[7][5] = Base.cGround;
        this.board[7][6] = Base.cGround;
        this.board[8][0] = Base.cGround;
        this.board[8][1] = Base.cGround;
        this.board[8][2] = Base.cGround;
        this.board[8][3] = Base.cGround;
        this.board[8][4] = Base.cGround;
        this.board[8][5] = Base.cGround;
        this.board[8][6] = Base.cGround;

        this.board[3][0] = Base.cGround;
        this.board[4][0] = Base.cGround;
        this.board[5][0] = Base.cGround;
        this.board[3][3] = Base.cGround;
        this.board[4][3] = Base.cGround;
        this.board[5][3] = Base.cGround;
        this.board[3][6] = Base.cGround;
        this.board[4][6] = Base.cGround;
        this.board[5][6] = Base.cGround;

        //place the pieces
        this.piece[0][0] = Piece.rLion;
        this.piece[0][1] = Piece.rbNone;
        this.piece[0][5] = Piece.rbNone;
        this.piece[0][6] = Piece.rTiger;
        this.piece[1][0] = Piece.rbNone;
        this.piece[1][1] = Piece.rDog;
        this.piece[1][2] = Piece.rbNone;
        this.piece[1][4] = Piece.rbNone;
        this.piece[1][5] = Piece.rCat;
        this.piece[1][6] = Piece.rbNone;
        this.piece[2][0] = Piece.rRat;
        this.piece[2][1] = Piece.rbNone;
        this.piece[2][2] = Piece.rLeopard;
        this.piece[2][3] = Piece.rbNone;
        this.piece[2][4] = Piece.rWolf;
        this.piece[2][5] = Piece.rbNone;
        this.piece[2][6] = Piece.rElephant;

        this.piece[3][0] = Piece.rbNone;
        this.piece[3][3] = Piece.rbNone;
        this.piece[3][6] = Piece.rbNone;
        this.piece[4][0] = Piece.rbNone;
        this.piece[4][3] = Piece.rbNone;
        this.piece[4][6] = Piece.rbNone;
        this.piece[5][0] = Piece.rbNone;
        this.piece[5][3] = Piece.rbNone;
        this.piece[5][6] = Piece.rbNone;

        this.piece[6][0] = Piece.bElephant;
        this.piece[6][1] = Piece.rbNone;
        this.piece[6][2] = Piece.bWolf;
        this.piece[6][3] = Piece.rbNone;
        this.piece[6][4] = Piece.bLeopard;
        this.piece[6][5] = Piece.rbNone;
        this.piece[6][6] = Piece.bRat;
        this.piece[7][0] = Piece.rbNone;
        this.piece[7][1] = Piece.bCat;
        this.piece[7][2] = Piece.rbNone;
        this.piece[7][4] = Piece.rbNone;
        this.piece[7][5] = Piece.bDog;
        this.piece[7][6] = Piece.rbNone;
        this.piece[8][0] = Piece.bTiger;
        this.piece[8][1] = Piece.rbNone;
        this.piece[8][5] = Piece.rbNone;
        this.piece[8][6] = Piece.bLion;

    }
    //-----------------------------------------------------------------------
    /** @returns the specific (moveable) piece (e.g., bWolf or rbNone) at the
     *  indicated position.
     *  @todo v1
     */
    public Piece getPiece(int r, int c) {

        if (r < 0 || c < 0)     return Piece.rbNone;
        if (r >= Board.fRows)   return Piece.rbNone;
        if (c >= Board.fCols)   return Piece.rbNone;

        if(piece[r][c] == Piece.rRat){
            return Piece.rRat;
        }
        else if(piece[r][c] == Piece.rCat) {
            return Piece.rCat;
        }
        else if(piece[r][c] == Piece.rDog){
            return Piece.rDog;
        }
        else if(piece[r][c] == Piece.rWolf){
            return Piece.rWolf;
        }
        else if(piece[r][c] == Piece.rLeopard){
            return Piece.rLeopard;
        }
        else if(piece[r][c] == Piece.rTiger){
            return Piece.rTiger;
        }
        else if(piece[r][c] == Piece.rLion){
            return Piece.rLion;
        }
        else if(piece[r][c] == Piece.rElephant){
            return Piece.rElephant;
        }
        else if(piece[r][c] == Piece.bRat){
            return Piece.bRat;
        }
        else if(piece[r][c] == Piece.bCat) {
            return Piece.bCat;
        }
        else if(piece[r][c] == Piece.bDog){
            return Piece.bDog;
        }
        else if(piece[r][c] == Piece.bWolf){
            return Piece.bWolf;
        }
        else if(piece[r][c] == Piece.bLeopard){
            return Piece.bLeopard;
        }
        else if(piece[r][c] == Piece.bTiger){
            return Piece.bTiger;
        }
        else if(piece[r][c] == Piece.bLion){
            return Piece.bLion;
        }
        else if(piece[r][c] == Piece.bElephant){
            return Piece.bElephant;
        }
        else if(r > 8 | r < 0 | c < 0 | c > 6){
            return(Piece.rbNone);
        }
        else{
            return Piece.rbNone;
        }
        //return Piece.rbNone;

    }
    //-----------------------------------------------------------------------
    /** @brief set the piece at the specified position (r,c).
     *  @param p should/must be rbNone or rRat ... rElephant or bRat ... bElephant.
     *  this function should NOT change the board contents (e.g., cWater) at
     *  the specified location.
     *  @todo v2
     */
    public void setPiece ( int r, int c, Piece p ) {

        if ((r < Board.fRows) && (r >= 0) && ( c >= 0 ) && (c < Board.fCols)){
            this.piece[r][c] = p;
        }
    }
    //-----------------------------------------------------------------------
    /** @returns what appears on the underlying board at the specified position
     *  (e.g., cWater), or cNone if out of bounds.
     * @todo v1
     */
    public Base getBoard ( int r, int c ) {

        if (r < 0 || c < 0)     return Base.cNone;
        if (r >= Board.fRows)   return Base.cNone;
        if (c >= Board.fCols)   return Base.cNone;

        if(board[r][c] == Base.cGround){
            return Base.cGround;
        }
        else if(board[r][c] == Base.cWater) {
            return Base.cWater;
        }
        else if(board[r][c] == Base.cRTrap) {
            return Base.cRTrap;
        }
        else if(board[r][c] == Base.cBTrap) {
            return Base.cBTrap;
        }
        else if(board[r][c] == Base.cRDen) {
            return Base.cRDen;
        }
        else if(board[r][c] == Base.cBDen) {
            return Base.cBDen;
        }
        else if(r > 8 | r < 0 | c < 0 | c > 6){
            return Base.cNone;
        }
        else{
            return Base.cNone;
        }

    }
    //-----------------------------------------------------------------------
    // given a piece, return its rank (or 0 for an unknown piece).
    // rat is 1, cat is 2, dog is 3, wolf is 4, leopard is 5, tiger is 6, lion
    // is 7, elephant is 8, regardless of color.
    // @todo v2
    public int getRank ( Piece p ) {
        int unknownRank = 0;
        int ratRank = 1;
        int catRank = 2;
        int dogRank = 3;
        int wolfRank = 4;
        int leopardRank = 5;
        int tigerRank = 6;
        int lionRank = 7;
        int elephantRank = 8;

        if(p == Piece.rRat || p == Piece.bRat){
            return ratRank;
        }
        else if(p == Piece.rCat || p == Piece.bCat) {
            return catRank;
        }
        else if(p == Piece.rDog || p == Piece.bDog){
            return dogRank;
        }
        else if(p == Piece.rWolf || p == Piece.bWolf){
            return wolfRank;
        }
        else if(p == Piece.rLeopard || p == Piece.bLeopard){
            return leopardRank;
        }
        else if(p == Piece.rTiger || p == Piece.bTiger){
            return tigerRank;
        }
        else if(p == Piece.rLion || p == Piece.bLion){
            return lionRank;
        }
        else if(p == Piece.rElephant || p == Piece.bElephant){
            return elephantRank;
        }
        else{
            return 0;
        }
    }
    //-----------------------------------------------------------------------
    // return the rank of the piece at the specified position (or 0 for none).
    // rat is 1, cat is 2, dog is 3, wolf is 4, leopard is 5, tiger is 6, lion
    // is 7, elephant is 8, regardless of color.
    // @todo v2
    public int getRank ( int r, int c ) {

        int unknownRank = 0;
        int ratRank = 1;
        int catRank = 2;
        int dogRank = 3;
        int wolfRank = 4;
        int leopardRank = 5;
        int tigerRank = 6;
        int lionRank = 7;
        int elephantRank = 8;

        if(this.piece[r][c] == Piece.rRat || this.piece[r][c] == Piece.bRat){
            return ratRank;
        }
        else if(this.piece[r][c] == Piece.rCat || this.piece[r][c] == Piece.bCat) {
            return catRank;
        }
        else if(this.piece[r][c] == Piece.rDog || this.piece[r][c] == Piece.bDog){
            return dogRank;
        }
        else if(this.piece[r][c] == Piece.rWolf || this.piece[r][c] == Piece.bWolf){
            return wolfRank;
        }
        else if(this.piece[r][c] == Piece.rLeopard || this.piece[r][c] == Piece.bLeopard){
            return leopardRank;
        }
        else if(this.piece[r][c] == Piece.rTiger || this.piece[r][c] == Piece.bTiger){
            return tigerRank;
        }
        else if(this.piece[r][c] == Piece.rLion || this.piece[r][c] == Piece.bLion){
            return lionRank;
        }
        else if(this.piece[r][c] == Piece.rElephant || this.piece[r][c] == Piece.bElephant){
            return elephantRank;
        }
        else{
            return 0;
        }
    }
    //-----------------------------------------------------------------------
    // returns the color of the piece (or Color.None) at the specified location.
    // @todo v2
    public GameColor getColor( int r, int c ) {

        String x = pieceToStr(r,c);
        char color = x.charAt(0);

        if(color == 'r') {
            return GameColor.Red;
        }
        else if(color == 'b'){
            return GameColor.Blue;
        }
        else{
            return GameColor.None;
        }
    }
    //-----------------------------------------------------------------------
    // returns the color of the piece (or Color.None) at the specified location.
    // @todo v2
    public GameColor getColor( Piece p ) {

        String x = pieceToStr(p);
        char color = x.charAt(0);

        if(color == 'r') {
            return GameColor.Red;
        }
        else if(color == 'b'){
            return GameColor.Blue;
        }
        else{
            return GameColor.None;
        }
    }
    //-----------------------------------------------------------------------
    // returns true if this spot does not have any (movable) piece on it;
    // false otherwise or if out of bounds.
    // @todo v2
    public boolean isEmpty ( int r, int c ) {

        if (r < 0 || c < 0)     return true;
        if (r >= Board.fRows)   return true;
        if (c >= Board.fCols)   return true;

        if(piece[r][c] == Piece.rRat){
            return false;
        }
        else if(piece[r][c] == Piece.rDog){
            return false;
        }
        else if(piece[r][c] == Piece.rWolf){
            return false;
        }
        else if(piece[r][c] == Piece.rLeopard){
            return false;
        }
        else if(piece[r][c] == Piece.rTiger){
            return false;
        }
        else if(piece[r][c] == Piece.rLion){
            return false;
        }
        else if(piece[r][c] == Piece.rElephant){
            return false;
        }
        else if(piece[r][c] == Piece.rCat){
            return false;
        }
        else if(piece[r][c] == Piece.bRat){
            return false;
        }
        else if(piece[r][c] == Piece.bDog){
            return false;
        }
        else if(piece[r][c] == Piece.bWolf){
            return false;
        }
        else if(piece[r][c] == Piece.bLeopard){
            return false;
        }
        else if(piece[r][c] == Piece.bTiger){
            return false;
        }
        else if(piece[r][c] == Piece.bLion){
            return false;
        }
        else if(piece[r][c] == Piece.bElephant){
            return false;
        }
        else if(piece[r][c] == Piece.bCat){
            return false;
        }
        else{
            return true;
        }
    }
    //-----------------------------------------------------------------------
    public String pieceToStr(int r, int c){

        if (r < 0 || c < 0)     return null;
        if (r >= Board.fRows)   return null;
        if (c >= Board.fCols)   return null;

        if(piece[r][c] == Piece.rRat){
            return "rRa";
        }
        else if(piece[r][c] == Piece.rDog){
            return "rDo";
        }
        else if(piece[r][c] == Piece.rWolf){
            return "rWo";
        }
        else if(piece[r][c] == Piece.rLeopard){
            return "rLe";
        }
        else if(piece[r][c] == Piece.rTiger){
            return "rTi";
        }
        else if(piece[r][c] == Piece.rLion){
            return "rLi";
        }
        else if(piece[r][c] == Piece.rElephant){
            return "rEl";
        }
        else if(piece[r][c] == Piece.rCat){
            return "rCa";
        }
        else if(piece[r][c] == Piece.bRat){
            return "bRa";
        }
        else if(piece[r][c] == Piece.bDog){
            return "bDo";
        }
        else if(piece[r][c] == Piece.bWolf){
            return "bWo";
        }
        else if(piece[r][c] == Piece.bLeopard){
            return "bLe";
        }
        else if(piece[r][c] == Piece.bTiger){
            return "bTi";
        }
        else if(piece[r][c] == Piece.bLion){
            return "bLi";
        }
        else if(piece[r][c] == Piece.bElephant){
            return "bEl";
        }
        else if(piece[r][c] == Piece.bCat){
            return "bCa";
        }
        else{
            return "non";
        }

    }

    public String pieceToStr(Piece p){

        if(p == Piece.rRat){
            return "rRa";
        }
        else if(p == Piece.rDog){
            return "rDo";
        }
        else if(p == Piece.rWolf){
            return "rWo";
        }
        else if(p == Piece.rLeopard){
            return "rLe";
        }
        else if(p == Piece.rTiger){
            return "rTi";
        }
        else if(p == Piece.rLion){
            return "rLi";
        }
        else if(p == Piece.rElephant){
            return "rEl";
        }
        else if(p == Piece.rCat){
            return "rCa";
        }
        else if(p == Piece.bRat){
            return "bRa";
        }
        else if(p == Piece.bDog){
            return "bDo";
        }
        else if(p == Piece.bWolf){
            return "bWo";
        }
        else if(p == Piece.bLeopard){
            return "bLe";
        }
        else if(p == Piece.bTiger){
            return "bTi";
        }
        else if(p == Piece.bLion){
            return "bLi";
        }
        else if(p == Piece.bElephant){
            return "bEl";
        }
        else if(p == Piece.bCat){
            return "bCa";
        }
        else{
            return "non";
        }

    }
    // returns true if the proposed move is valid (regardless of whose turn it
    // is); false otherwise.
    // this is the most challenging part of the assignment!
    protected boolean isValidMove ( int fromRow, int fromCol, int toRow, int toCol ) {
        // \todo v3

        //Piece is moving left or right but only 1 square move is valid
        if (fromRow == toRow)
        {
            if (Math.abs(toCol - fromCol) > 1 ) {
                return false;
            }
        }
        //Piece is moving top or bottom but only 1 square move is valid
        if (fromCol == toCol)
        {
            if (Math.abs(toRow - fromRow) > 1 ) {
                return false;
            }
        }
        //Piece is not allowed to move diagonally
        if ((Math.abs(toCol - fromCol) > 0 ) && (Math.abs(toRow - fromRow) > 0))
            return false;

        return true;
    }
    //-----------------------------------------------------------------------
    // perform the specified move but only if it's valid. unlike the above
    // function, this function will make sure that it is the
    // appropriate player's turn. if the move is performed, the player's turn
    // is changed to the other player.
    // return true if the proposed move is valid; false otherwise.
    //
    public boolean doMove ( int fromRow, int fromCol, int toRow, int toCol ) {
        // \todo v3
        if (isValidMove(fromRow,fromCol,toRow,toCol)) {
            if (bluesTurn)
                if (getColor(getPiece(fromRow,fromCol)) == GameColor.Red)
                    return false;
                else
                    bluesTurn = false;
            else
                if (getColor(getPiece(fromRow,fromCol)) == GameColor.Blue)
                    return false;
                else
                    bluesTurn = true;
        }
        else
            return false;
        return true;
    }

    //-----------------------------------------------------------------------
    // returns a string representing the board that can be pretty-printed.
    // it should look something like the following:
    //
    //     --...-        --...-     \n
    //    |      |      |      |    \n
    //    .      .      .      .     .
    //    .      .      .      .     .
    //    .      .      .      .     .
    //    |      |      |      |    \n
    //     --...-        --...-     \n
    //
    // the left side of the string should be the underlying board.
    // the right side should be the pieces at their specific locations.
    // put the first 3 characters of the name at each location
    // (e.g., rLi for the red lion, and bEl for the blue elephant).
    //
    // if you have a better idea, please let me know!
    @Override
    public String toString ( ) {

        Piece xr = getPiece(0, 0);

        String isEmptyTest;
        if(isEmpty(1, 1)) isEmptyTest = "Empty";
        else isEmptyTest = "Not Empty";

        String gameColorZ;
        if(getColor(0,0) == GameColor.Blue){
            gameColorZ = "blue";
        }
        else if (getColor(0,0) == GameColor.Red){
            gameColorZ = "red";
        }
        else if (getColor(0,0) == GameColor.None) {
            gameColorZ = "none";
        }
        else
            gameColorZ = "x";

        String gameColorY;
        if(getColor(getPiece(0,0)) == GameColor.Blue) gameColorY = "blue";
        else if (getColor(getPiece(0,0)) == GameColor.Red) gameColorY = "red";
        else gameColorY = "none";




        String s;
              s = ("-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  G  | RT  | RD  | RT  |  G  |  G  |            | rLi |     |     |     |     |     | rTi |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  G  |  G  | RT  |  G  |  G  |  G  |            |     | rDo |     |     |     | rCa |     |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  G  |  G  |  G  |  G  |  G  |  G  |            | rRa |     | rLe |     | rWo |     | rEl |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  W  |  W  |  G  |  W  |  W  |  G  |            |     |     |     |     |     |     |     |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  W  |  W  |  G  |  W  |  W  |  G  |            |     |     |     |     |     |     |     |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  W  |  W  |  G  |  W  |  W  |  G  |            |     |     |     |     |     |     |     |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  G  |  G  |  G  |  G  |  G  |  G  |            | bEl |     | bWo |     | rLe |     | bEl |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  G  |  G  | BT  |  G  |  G  |  G  |            |     | bCa |     |     |     | bDo |     |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "|  G  |  G  | BT  | RD  | RT  |  G  |  G  |            | bTi |     |     |     |     |     | bLi |\n" +
                   "-------------------------------------------            -------------------------------------------\n" +
                   "getPiece test: " + xr + "\nisEmpty test: " + isEmptyTest + "\ngetColor with p parameter test: " + gameColorY + "\ngetColor with coordinates test: " + gameColorZ + "\npieceToString test: " + pieceToStr(0,0));


        // @todo v1
        return s;
    }

}  //end class Board
