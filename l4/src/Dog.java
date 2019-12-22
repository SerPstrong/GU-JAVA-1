public class Dog extends Animals {
    int maxDistRun = 500;
    int maxDistSwim = 10;
    float maxDistJump = 0.5f;
    public Dog () {
    }

    public Dog (String name, int _run, int _swim, float _jump) {
        this.name = name;
        /*
        как это работает - проверяется значего _параметра
        если оно в допустимом интервале, то значение присваивается, если выходит за пределы,
        то присваивается минимально или максимальное значение из диопозона
         */
        if (_run >= 0 && _run <= maxDistRun) {
            this.run = _run;
        } else if (_run < 0) this.run = 0;
        else if (_run > maxDistRun) this.run = maxDistRun;

        if (_swim >= 0 && _swim <= maxDistSwim) {
            this.swim = _swim;
        } else if (_swim < 0) this.swim = 0;
        else if (_swim > maxDistSwim) this.swim = maxDistSwim;

        if (_jump >= 0 && _jump <= 0.5f) {
            this.jump = _jump;
        } else if (_jump < 0) this.jump = 0;
        else if (_jump > maxDistJump) this.jump = maxDistJump;
    }

    public void dogInfo () {
        System.out.println(this.name + " " + this.run + " " + this.swim + " " + this.jump);
    }


}
