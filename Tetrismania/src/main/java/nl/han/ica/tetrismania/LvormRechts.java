package nl.han.ica.tetrismania;

public class LvormRechts extends Steen {
	
	private int positie;

	public LvormRechts(int x, int y, Tetrismania tm) {
		tekenLvormRechts(x, y, tm);

	}

	private void tekenLvormRechts(int x, int y, Tetrismania app) {
		SteenTile steenLBoven = new SteenTile(x + 40, y, this);
		SteenTile steenMiddenLinks = new SteenTile(x + 40, y + 40, this);
		SteenTile steenMiddenRechts = new SteenTile(x + 40, y + 80, this);
		SteenTile steenRBeneden = new SteenTile(x + 80, y + 80, this);
		tiles[0] = steenLBoven;
		tiles[1] = steenMiddenLinks;
		tiles[2] = steenMiddenRechts;
		tiles[3] = steenRBeneden;
		app.addGameObject(steenLBoven);
		app.addGameObject(steenMiddenLinks);
		app.addGameObject(steenMiddenRechts);
		app.addGameObject(steenRBeneden);
	}

	@Override
	public void draaiLinksom() {
		System.out.println(positie);
		if (positie == 3) {
			positie = 0;
		} else {
			positie += 1;
		}
		System.out.println(positie);
		switch (positie) {
		case 2:
            tiles[0].setX(tiles[0].getX() + 0);
            tiles[1].setX(tiles[1].getX() + 40);
            tiles[2].setX(tiles[2].getX() + 0);
            tiles[3].setX(tiles[3].getX() - 40);

            tiles[0].setY(tiles[0].getY() - 40);
            tiles[1].setY(tiles[1].getY() + 0);
            tiles[2].setY(tiles[2].getY() + 40);
            tiles[3].setY(tiles[3].getY() - 40);
            break;
        case 3:
            tiles[0].setX(tiles[0].getX() + 80);
            tiles[1].setX(tiles[1].getX() + 40);
            tiles[2].setX(tiles[2].getX() + 0);
            tiles[3].setX(tiles[3].getX() - 40);

            tiles[0].setY(tiles[0].getY() + 0);
            tiles[1].setY(tiles[1].getY() + 40);
            tiles[2].setY(tiles[2].getY() + 0);
            tiles[3].setY(tiles[3].getY() - 40);
            break;
        case 0:
            tiles[0].setX(tiles[0].getX() + 0);
            tiles[1].setX(tiles[1].getX() + 40);
            tiles[2].setX(tiles[2].getX() + 0);
            tiles[3].setX(tiles[3].getX() + 40);

            tiles[0].setY(tiles[0].getY() + 80);
            tiles[1].setY(tiles[1].getY() + 40);
            tiles[2].setY(tiles[2].getY() + 0);
            tiles[3].setY(tiles[3].getY() - 40);
            break;
        case 1:
            tiles[0].setX(tiles[0].getX() - 80);
            tiles[1].setX(tiles[1].getX() - 40);
            tiles[2].setX(tiles[2].getX() + 0);
            tiles[3].setX(tiles[3].getX() + 40);

            tiles[0].setY(tiles[0].getY() - 40);
            tiles[1].setY(tiles[1].getY() - 80);
            tiles[2].setY(tiles[2].getY() - 40);
            tiles[3].setY(tiles[3].getY() - 80);
            break;
		}

	}

	@Override
	public void draaiRechtsom() {
		// TODO Auto-generated method stub

	}

}
