
var board = [[0,0,1,0,0],[0,1,0,1,0],[1,0,1,0,1],[0,1,0,1,0],[0,0,1,0,0]];

function solution(board) {

    var temp = [];
    for(var i=0; i<board.length; i++) {
        var arr = [];
        for(var j=0; j<board[i].length; j++) {
            if(board[i][j] == 1) {
                arr.push(j);
            }
        }
        temp.push(arr);
    }

    for(var i=0; i<temp.length; i++) {
        var arr = temp[i];
        if(arr.length >= 2) {
            var temp = null;
            for(var j=0; j<temp[i].length; j++) {


            }
        }
    }


}

solution(board);
