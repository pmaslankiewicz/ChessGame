package com.lucas.ChessGame;

public class ChessBoard {
    // a structural note - package name should be lowercase and domain reverse order meaning: src/main/com/java/lucas/chessgame
    // all the figures (abstract and concrete) should be under models/figures
    // there should be a directory for your config enums holding type and color

    Figures[][] boardArray = new Figures[8][8];

    public ChessBoard() {
        boardSetUp();
    }

    // makeMove() -
    // String startCoordinates and String endCoordinates
    // are declared by the player
    
    // makeAMove should be a method that a Player has, the board should have a method playGame that creates PLayers, starts the game and calls players in turn and checks for the mate after each move
    // Player should have available pieces and therefore available moves to chose from as part of his move
    public void makeAMove(String startCoordinates, String endCoordinates) {
        Figures figure = whatStandsHere(startCoordinates);
        for (String possibleMove : figure.getPossibleMovements()) {
            if (checkIfTheMoveIsValid(figure, endCoordinates)) {
                if (possibleMove.equals(endCoordinates)) {
                    //placing the figure on the endCoordinates
                    int endRow = getRow(endCoordinates);
                    int endColumn = getColumn(endCoordinates);
                    boardArray[endRow][endColumn] = figure;
                    figure.setCurrentPosition(endCoordinates);

                    //clearing the startCoordinates after the figure
                    int startRow = getRow(startCoordinates);
                    int startColumn = getColumn(startCoordinates);
                    boardArray[startRow][startColumn] = null;

                    //notification for me about whether the figure move was successful
                    System.out.printf("\n Valid move %s -> %s == %s\n", startCoordinates, endCoordinates, possibleMove);
                }
            }
        }

    }

    private boolean checkIfTheMoveIsValid(Figures figure, String endCoordinates) {
        int row = getRow(endCoordinates);
        int column = getColumn(endCoordinates);
        if ((row >= 0 && row <= 8) && (column >= 0 && column <= 8)) {
            if (whatStandsHere(endCoordinates) != null) {
                Figures opponent = whatStandsHere(endCoordinates);
                return opponent.getColor() != figure.getColor();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    //boardSetUp() -
    // This function is used in the chess board constructor.
    // It is used to place thirty-two figures on the board
    // as it should look at the beginning of the game.
    public void boardSetUp() { // this whole method should be a service class, with its public method called in the constructor of ChessBoard

        // extend enums to store the information about the starting posisions of the each piece type for each color - that would remove those pointless fors
        // do something like for(color: colors) { for (type: types) { setupPieces(color, type) }} - that would get rid of the nasty repetition 
        //white Pawns
        for (int i = 0; i < 8; i++) { 
            Pawn pawn = new Pawn(Type.PAWN, Color.WHITE);
            //determining the initial coordinates of the figure
            String startPosition = getStartPosition(pawn.getType(), pawn.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            //saving the initial coordinates in pawn.currentPosition (figures.currentPosition)
            pawn.setCurrentPosition(startPosition);
            //placing the figure on the board
            this.boardArray[row][column] = pawn;
        }

        //black Pawns
        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(Type.PAWN, Color.BLACK);
            String startPosition = getStartPosition(pawn.getType(), pawn.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            pawn.setCurrentPosition(startPosition);
            this.boardArray[row][column] = pawn;
        }

        //white King
        for (int i = 0; i < 1; i++) {
            King king = new King(Type.KING, Color.WHITE);
            String startPosition = getStartPosition(king.getType(), king.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            king.setCurrentPosition(startPosition);
            this.boardArray[row][column] = king;
        }

        //black King
        for (int i = 0; i < 1; i++) {
            King king = new King(Type.KING, Color.BLACK);
            String startPosition = getStartPosition(king.getType(), king.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            king.setCurrentPosition(startPosition);
            this.boardArray[row][column] = king;
        }

        //white Queen
        for (int i = 0; i < 1; i++) {
            Queen queen = new Queen(Type.QUEEN, Color.WHITE);
            String startPosition = getStartPosition(queen.getType(), queen.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            queen.setCurrentPosition(startPosition);
            this.boardArray[row][column] = queen;
        }

        //black Queen
        for (int i = 0; i < 1; i++) {
            Queen queen = new Queen(Type.QUEEN, Color.BLACK);
            String startPosition = getStartPosition(queen.getType(), queen.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            queen.setCurrentPosition(startPosition);
            this.boardArray[row][column] = queen;
        }
        //white Rooks
        for (int i = 0; i < 2; i++) {
            Rook rook = new Rook(Type.ROOK, Color.WHITE);
            String startPosition = getStartPosition(rook.getType(), rook.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            rook.setCurrentPosition(startPosition);
            this.boardArray[row][column] = rook;
        }

        //black Rooks
        for (int i = 0; i < 2; i++) {
            Rook rook = new Rook(Type.ROOK, Color.BLACK);
            String startPosition = getStartPosition(rook.getType(), rook.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            rook.setCurrentPosition(startPosition);
            this.boardArray[row][column] = rook;
        }

        //white Bishops
        for (int i = 0; i < 2; i++) {
            Bishop bishop = new Bishop(Type.BISHOP, Color.WHITE);
            String startPosition = getStartPosition(bishop.getType(), bishop.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            bishop.setCurrentPosition(startPosition);
            this.boardArray[row][column] = bishop;
        }

        //black Bishops
        for (int i = 0; i < 2; i++) {
            Bishop bishop = new Bishop(Type.BISHOP, Color.BLACK);
            String startPosition = getStartPosition(bishop.getType(), bishop.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            bishop.setCurrentPosition(startPosition);
            this.boardArray[row][column] = bishop;
        }

        //white Knights
        for (int i = 0; i < 2; i++) {
            Knight knight = new Knight(Type.KNIGHT, Color.WHITE);
            String startPosition = getStartPosition(knight.getType(), knight.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            knight.setCurrentPosition(startPosition);
            this.boardArray[row][column] = knight;
        }

        //black Knights
        for (int i = 0; i < 2; i++) {
            Knight knight = new Knight(Type.KNIGHT, Color.BLACK);
            String startPosition = getStartPosition(knight.getType(), knight.getColor());
            int row = getRow(startPosition);
            int column = getColumn(startPosition);
            this.boardArray[row][column] = knight;
        }
    }

    // use numbers for coordinates throughout the code, only turn it to string when showing to the user
    public Figures whatStandsHere(String coordinates) {
        return boardArray[getRow(coordinates)][getColumn(coordinates)];
    }

    public static int getRow(String coordinates) {
        int rowNumber = Integer.parseInt(coordinates.substring(1));
        return rowNumber - 1;
    }

    public static int getColumn(String coordinates) {
        char columnLetter = coordinates.charAt(0);
        return (int) columnLetter - 97;
    }

    public String printBoard() {
        StringBuilder answer = new StringBuilder();
        for (Figures[] boardRows : this.boardArray) {
            for (Figures figure : boardRows) {
                if (figure != null) {
                    answer.append(figure).append(" ");
                } else {
                    answer.append("       null      ||");
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }

    // all that information belongs with the specific type, not in the board class
    private String getStartPosition(Type type, Color color) {
        return switch (type) {
            case KING -> color.toString().equals("WHITE") ? "e1" : "e8";
            case QUEEN -> color.toString().equals("WHITE") ? "d1" : "d8";
            case ROOK -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("a1") == null) {
                        // you're setting up the board, you shouldn't be worried about something being there, everything should be null at this point
                        // if you want to be sure create method clear() in the ChessBoard class that will clear the whole board nulling all the fields
                        yield "a1";
                    } else if (whatStandsHere("h1") == null) {
                        yield "h1";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("a8") == null) {
                        yield "a8";
                    } else if (whatStandsHere("h8") == null) {
                        yield "h8";
                    } else {
                        yield null;
                    }
                }
            }
            case KNIGHT -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("b1") == null) {
                        yield "b1";
                    } else if (whatStandsHere("g1") == null) {
                        yield "g1";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("b8") == null) {
                        yield "b8";
                    } else if (whatStandsHere("g8") == null) {
                        yield "g8";
                    } else {
                        yield null;
                    }
                }
            }
            case BISHOP -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("c1") == null) {
                        yield "c1";
                    } else if (whatStandsHere("f1") == null) {
                        yield "f1";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("c8") == null) {
                        yield "c8";
                    } else if (whatStandsHere("f8") == null) {
                        yield "f8";
                    } else {
                        yield null;
                    }
                }
            }
            case PAWN -> {
                if (color.toString().equals("WHITE")) {
                    if (whatStandsHere("a2") == null) {
                        yield "a2";
                    } else if (whatStandsHere("b2") == null) {
                        yield "b2";
                    } else if (whatStandsHere("c2") == null) {
                        yield "c2";
                    } else if (whatStandsHere("d2") == null) {
                        yield "d2";
                    } else if (whatStandsHere("e2") == null) {
                        yield "e2";
                    } else if (whatStandsHere("f2") == null) {
                        yield "f2";
                    } else if (whatStandsHere("g2") == null) {
                        yield "g2";
                    } else if (whatStandsHere("h2") == null) {
                        yield "h2";
                    } else {
                        yield null;
                    }
                } else {
                    if (whatStandsHere("a7") == null) {
                        yield "a7";
                    } else if (whatStandsHere("b7") == null) {
                        yield "b7";
                    } else if (whatStandsHere("c7") == null) {
                        yield "c7";
                    } else if (whatStandsHere("d7") == null) {
                        yield "d7";
                    } else if (whatStandsHere("e7") == null) {
                        yield "e7";
                    } else if (whatStandsHere("f7") == null) {
                        yield "f7";
                    } else if (whatStandsHere("g7") == null) {
                        yield "g7";
                    } else if (whatStandsHere("h7") == null) {
                        yield "h7";
                    } else {
                        yield null;
                    }
                }
            }
        };
    }
}
