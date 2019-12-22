public class Cat extends Animals {
    int maxDistRun = 200;
    int maxDistSwim = 0;
    float maxDistJump = 2;
    int maxFood = 7;

    public Cat() {
    }

    public Cat(String _name, int _run, int _swim, float _jump, int _food) {
        this.name = _name;
        /*как это работает - проверяется значего _параметра
        если оно в допустимом интервале, то значение присваивается, если выходит за пределы,
        то присваивается минимально или максимальное значение из диопозона
         */
        if (_run >= 0 && _run <= maxDistRun) {
            this.run = _run;
        } else if (_run < 0) this.run = 0;
        else if (_run > maxDistRun) this.run = maxDistRun;

        if (_swim == maxDistSwim) {
            this.swim = _swim;
        } else this.swim = 0;

        if (_jump >= 0 && _jump <= maxDistJump) {
            this.jump = _jump;
        } else if (_jump < 0) this.jump = 0;
        else if (_jump > maxDistJump) this.jump = maxDistJump;

        if (_food >= 0 && _jump <= maxFood) {
            this.food = maxFood;
        } else this.food = 0;
    }

    public void catInfo() {
        System.out.println(this.name + " " + this.run + " " + this.swim + " " + this.jump + " " + this.food);
    }
}
