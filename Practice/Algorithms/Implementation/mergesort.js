// 2 arrays - unsorted
// mrge and sort

const mergesort = (arr1, arr2) => {
    const combined = [...arr1, ...arr2];
    sort(combined, 0, combined.length - 1);
    return combined;
}

const sort = (arr, lo, hi) => {
    if(lo < hi) {
        const mid = Math.floor(lo + (hi - lo) / 2);
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }
}

const merge = (arr, lo, mid, hi) => {
    const n1 = mid - lo + 1, n2 = hi - mid;
    const leftArr = [], rightArr = [];

    for(let i = 0; i < n1; i++) leftArr[i] = arr[lo + i];
    for(let i = 0; i < n2; i++) rightArr[i] = arr[mid + i + 1];

    let i = 0, j = 0, k = lo;

    while(i < n1 && j < n2) {
        if(leftArr[i] < rightArr[j]) {
            arr[k++] = leftArr[i++];
        } else {
            arr[k++] = rightArr[j++];
        }
    }

    while(i < n1) {
        arr[k++] = leftArr[i++];
    }
    while(j < n2) {
        arr[k++] = rightArr[j++];
    }
}

console.log(mergesort([3,5,1], [2,6,7]));