let res = [];

const flattenHelper = (x) => {
    if(Array.isArray(x)) flatten(x);
    else res.push(x);
}

const flatten = (x) => {
    for(let i = 0; i < x.length; i++) {
        flattenHelper(x[i]);
    }
}

flatten([[1,2], [1], [4,5,[6,[7,8,9], 10]]]);
console.log(res);
