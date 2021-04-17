package geekbrains.quarter1.lesson_1_8.core;

import geekbrains.quarter1.lesson_1_8.core.domain.MatrixCoordinate;
import geekbrains.quarter1.lesson_1_8.enums.DotType;

public interface GameService {

    MatrixCoordinate aiTurn();

    void humanTurn(int rowIndex, int columnIndex);

    boolean checkWin(DotType dotType);

    boolean isMapFull();

}
