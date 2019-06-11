const getData = (ev) => {
    // console.log("Worked");
    console.log(ev.key);
}

const debounce = function(fn, d) {
    let timer;
    return function (...args) {
        const context = this;
        clearTimeout(timer);
        timer = setTimeout(() => {
            fn.apply(context, args)
        }, d); 
    }
}

const betterGet = debounce(getData, 600);