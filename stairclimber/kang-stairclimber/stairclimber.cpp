/*******************************************************************************
 * Name        : stairclimber.cpp
 * Author      : Harkirat Kang
 * Date        : Feb 21st 2017
 * Description : Lists the number of ways to climb n stairs.
 * Pledge      : I pledge my honor that I have abided by the stevens honor system
 ******************************************************************************/
#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>
#include <iomanip>

using namespace std;


vector< vector<int> > ways;
vector<int> way;

vector< vector<int> > get_ways(int num_stairs){
    // TODO: Return a vector of vectors of ints representing
    // the different combinations of ways to climb num_stairs
    // stairs, moving up either 1, 2, or 3 stairs at a time.

	if (num_stairs <= 0) {
		ways.push_back(way);
	}
	else {
		for (int i = 1; i <= 3; i++){
			if (num_stairs >= i){
				way.push_back(i);
				get_ways(num_stairs - i);
				way.pop_back();
			}
		}
	}
	return ways;
}

void display_ways(const vector< vector<int> > &ways) {
    // TODO: Display the ways to climb stairs by iterating over
    // the vector of vectors and printing each combination.
	for(unsigned int i = 0; i < ways.size(); i++){
		if(ways.size() >= 10 && i < 9){
				cout << " " << i + 1 << ". " << "[";
		}
		else{
			cout << i + 1 << ". " << "[";
		}
		for(unsigned int j = 0; j < ways[i].size(); j++){
			if(j == (ways[i].size() - 1)){
				cout << ways[i][j];
			}
			else{
				cout << ways[i][j] << ", ";
			}
		}
		cout << "]" << endl;
	}
}

int main(int argc, char * const argv[]) {

	int stairs;

	if (argc != 2){
			cerr << "Usage: ./stairclimber <number of stairs>";
			return 1;
		}

	istringstream iss(argv[1]);
	if (!(iss >> stairs)){
		cerr << "Error: Number of stairs must be a positive integer.";
		return 1;
	}

	if(stairs <= 0){
		cerr << "Error: Number of stairs must be a positive integer.";
		return 1;
	}

	vector< vector<int> > ways_found = get_ways(stairs);

	if(stairs == 1){
		cout << ways_found.size() << " way to climb " << stairs << " stair." << endl;
	}

	else if (stairs > 1){
		cout << ways_found.size() << " ways to climb " << stairs << " stairs." << endl;
	}

	display_ways(ways_found);



}
