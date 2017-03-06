/*
 * gcd.cpp
 *
 *  Created on: Jan 25, 2017
 *      Author: Harkirat Kang
 *      I pledge my honor that I have abided by the stevens honor system
 */

#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int max(int m, int n){
	if (n > m){
		return n;
	}
	else{
		return m;
	}
}

int recursiveGCD(int m, int n){

	if(m == 0 || n == 0){
		cout << "Recursive: gcd(" << m << ", " << n << ") = " << max(m, n)<< endl;
	}

	// if m is less than n, switch the variables and then implement the function
	if (m < n){
		return recursiveGCD(n, m);
	}
	//implement gcd function recursively
	int y = m % n;
	if (y == 0){
		return n;
	}
	else{
		return recursiveGCD(n, y);
	}
}

int iterativeGCD(int m, int n){

	// implement iteratively
	while (n != 0){
		int x = m % n;
		m = n;
		n = x;
	}
	return m;
}


int main(int argc, char * const argv[]){
	//define m and n as variables that take in the respective 1st and 2nd arguments
	int m, n;
	istringstream iss;

	//if there are not two arguments given with the function, let the user know that this can't run w/o them
	if (argc != 3){
		cerr << "Usage: " << argv[0] << " <integer m> <integer n>" << endl;
		return 1;
	}

	iss.str(argv[1]);
	if  (!(iss >> m)) {
		cerr << "Error: The first argument is not a valid integer." << endl;
		return 1;
	}

	iss.clear();
	iss.str(argv[2]);
	if  (!(iss >> n)) {
			cerr << "Error: The second argument is not a valid integer." << endl;
			return 1;
	}

	//returns iterative gcd of given arguments
	cout << "Iterative: gcd(" << argv[1] << ", " << argv[2] << ") = " << iterativeGCD(m, n) << endl;

	//return recursive gcd
	cout << "Recursive: gcd(" << argv[1] << ", " << argv[2] << ") = " << recursiveGCD(m, n) << endl;


}

















