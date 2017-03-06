/*
 * gcd.cpp
 *
 *  Created on: Jan 25, 2017
 *      Author: harkiratkang
 */

#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main(int argc, char** argv){
	int m = atoi(argv[1]);
	int n = atoi(argv[2]);

	if (argc != 3){
		cerr << "Usage: " << argv[0] << "<integer m> <integer n>" << endl;
		return 1;
	}

	if (m <= n){
		m = n;
		n = m;
		}
	while (n > 0){
		int x = m % n;
		m = n;
		n = x;
		}
	cout << "gcd(" << n << "," << m << ") = " << m << endl;
	}














