/*
 * cs385a.cpp
 *
 *  Created on: Jan 25, 2017
 *      Author: harkiratkang
 */


#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main(int argc, char * const argv[]){
	int m, n;
	istringstream iss;

	if (argc != 3){
		cerr << "Usage: " << argv[0] << "<interger m> <integer n>" << endl;
		return 1;
	}

	iss.str(argv[1]);
	if  (!(iss >> m)) {
		cerr << "you suck! M needs to be an integer." << endl;
		return 1;
	}
	iss.clear();
	iss.str(argv[2]);
	if  (!(iss >> n)) {
			cerr << "you suck bad! n needs to be an integer." << endl;
			return 1;

	}

	if (n > m) {
		cout << "max(" << n << "," << m << ") =" << n << endl;
	} else {
		cout << "max(" << n << "," << m << ") =" << m << endl;
	}
	return 0;

	}

