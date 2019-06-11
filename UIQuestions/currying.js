const sum = (x) => {
    return (y) => {
        if(!y) return x;
        return sum(x + y);
    }
}

console.log(sum(1)(2)(3)(4)(5)(6)());