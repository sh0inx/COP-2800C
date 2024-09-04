public class EmployeeBonus extends Employee {


    int[][] bonusTable = new int[7][5];

    public EmployeeBonus() {
        setBonusTable();
    }

    public EmployeeBonus(String name, int weeksWorked, int positiveReviews) {
        super(name, weeksWorked, positiveReviews);
        setBonusTable();
    }

    private void setBonusTable() {

        //weeks - 0
        bonusTable[0][0] = 25;
        bonusTable[0][1] = 45;
        bonusTable[0][2] = 80;
        bonusTable[0][3] = 110;
        bonusTable[0][4] = 150;

        //weeks - 1
        bonusTable[1][0] = 50;
        bonusTable[1][1] = 75;
        bonusTable[1][2] = 90;
        bonusTable[1][3] = 120;
        bonusTable[1][4] = 180;

        //weeks - 2
        bonusTable[2][0] = 100;
        bonusTable[2][1] = 125;
        bonusTable[2][2] = 160;
        bonusTable[2][3] = 210;
        bonusTable[2][4] = 265;

        //weeks - 3
        bonusTable[3][0] = 160;
        bonusTable[3][1] = 190;
        bonusTable[3][2] = 225;
        bonusTable[3][3] = 275;
        bonusTable[3][4] = 340;

        //weeks - 4
        bonusTable[4][0] = 235;
        bonusTable[4][1] = 265;
        bonusTable[4][2] = 325;
        bonusTable[4][3] = 385;
        bonusTable[4][4] = 450;

        //weeks - 5
        bonusTable[5][0] = 300;
        bonusTable[5][1] = 360;
        bonusTable[5][2] = 420;
        bonusTable[5][3] = 480;
        bonusTable[5][4] = 600;

        //weeks - 6 or more
        bonusTable[6][0] = 425;
        bonusTable[6][1] = 500;
        bonusTable[6][2] = 585;
        bonusTable[6][3] = 725;
        bonusTable[6][4] = 875;
    }

    public int getBonus() {
        return bonusTable[getWeeksWorked()][getPositiveReviews()];
    }
}
