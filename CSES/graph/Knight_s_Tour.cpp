/*
    Tag: Backtracking, Warnsdorf's Rule
*/
#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> board;

int delr[] = {-2, -2, -1, -1, 1, 1, 2, 2};
int delc[] = {-1, 1, 2, -2, 2, -2, 1, -1};

// count the remained valid moves from the current given position
int countNextMoves(int x, int y){
    int validNextMoves = 0;
    for (int i = 0; i < 8; i++){
        int new_x = x + delr[i];
        int new_y = y + delc[i];

        if(new_x >= 1 && new_y >= 1 && new_x <= 8 && new_y <= 8){
            if(board[new_x][new_y] == -1)
                validNextMoves++;
        }
    }
    return validNextMoves;
}


void printValidSequenceOfMoves(int x, int y){
    if(board[x][y] == 64){
        return;
    }

    vector<pair<int, pair<int, int>>> nextMoves; 

    for (int i = 0; i < 8; i++){
        int new_x = x + delr[i];
        int new_y = y + delc[i];

        if(new_x >= 1 && new_y >= 1 && new_x <= 8 && new_y <= 8){
            if(board[new_x][new_y] == -1){
                int degree = countNextMoves(new_x, new_y); // count the valid moves from {new_x, new_y} position
                nextMoves.push_back({degree, {new_x, new_y}});
            }
        }
    }

    // sort the nextMoves in ascending order of the remained valid move 
    sort(nextMoves.begin(), nextMoves.end());

    for (auto &nextMove : nextMoves){
        int new_x = nextMove.second.first;
        int new_y = nextMove.second.second;

        board[new_x][new_y] = board[x][y] + 1;
        printValidSequenceOfMoves(new_x, new_y);

        if(board[new_x][new_y] != -1) return;
    }

    board[x][y] = -1;
}

int main(){
    int y, x;
    cin >> y >> x;

    board.resize(9, vector<int>(9, -1));

    board[x][y] = 1;
    printValidSequenceOfMoves(x, y);

    for (int i = 1; i <= 8; i++){
        for (int j = 1; j <= 8; j++){
            if(j > 1)
                cout << " ";
            cout << board[i][j];
        }
        cout << "\n";
    }
}