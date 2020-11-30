function Robot() {
    this.work = function () {
        console.log("I'm robot, I'm working.")
    }
}

function CoffeeRobot() {
    Robot.call(this);
    this.work = function () {
        console.log("I'm CoffeeRobot,I'm making coffee");
    }
}

function DancerRobot() {
    Robot.call(this);
    this.work = function () {
        console.log("I'm DancerRobot, I'm dansing");
    }
}

function CookerRobot() {
    Robot.call(this);
    this.work = function () {
        console.log("I'm CookerRobot,I'm cooking.");
    }
}

let robot = new Robot();
robot.work();

let coffeeRobot = new CoffeeRobot();
coffeeRobot.work();

let dancerRobot = new DancerRobot();
dancerRobot.work();

let cookerRobot = new CookerRobot();
cookerRobot.work();

console.log("All robots.");

let massRobots = [robot, coffeeRobot, dancerRobot, cookerRobot];
for (let i = 0; i < massRobots.length; i++) {
    massRobots[i].work();
}

