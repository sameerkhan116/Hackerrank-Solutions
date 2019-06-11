const name = {
    firstName: 'Sameer'
};

const printName = function(lastName, age) {
    console.log(this.firstName + " " + lastName + " " + age);
}

const printMyName = printName.bind(name);
// printMyName();

Function.prototype.myBind = function(val, ...pargs) {
    const fn = this;
    return function(...args) {
        fn.call(val, pargs, args);
    }
}

printName.myBind(name, "Khan")(23);

