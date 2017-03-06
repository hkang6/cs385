/*******************************************************************************
 * Name        : unique.cpp
 * Author      : Harkirat Kang
 * Date        : 2.14.17
 * Description : Determining uniqueness of chars with int as bit vector.
 * Pledge      : I pledge my honor that I have abided by the Stevens honor system
 ******************************************************************************/
#include <iostream>
#include <sstream>
#include <cctype>

using namespace std;

bool is_all_lowercase(const string &s) {
    // returns true if all characters in string are lowercase
    // letters in the English alphabet; false otherwise.
	for(unsigned int i = 0; i < s.length(); i++){

		if(islower(s[i])){
			continue;
		}

		else{
			return false;
		}

	}

	return true;
}

bool all_unique_letters(const string &s) {
    // returns true if all letters in string are unique, that is
    // no duplicates are found; false otherwise.
    // You may use only a single int for storage and work with bitwise
    // and bitshifting operators.
    // No credit will be given for other solutions.

	//checks if letters are lowercase, returns false automatically if not
	if(is_all_lowercase(s) == 0){
		return false;
	}


	//
	else{

		int current;

		for(unsigned int i = 0; i < s.length(); i++){
			current = 1 << ((int)s[i] - 'a');
			for(unsigned int j = i + 1; j < s.length(); j++){
				if((current & (1 << ((int)s[j] - 'a'))) > 0){
					return false;
				}
			}
		}

	}

	return true;
}

int main(int argc, char * const argv[]) {
    // reads and parses command line arguments.
    // Calls other functions to produce correct output.

	//if the number of arguments given is unsatisfactory, return an error
	if (argc != 2){
		cerr << "Usage: ./unique <string>";
		return 1;
	}

	string input;

	//if the input does not contain only letters, return an error
	istringstream iss(argv[1]);
	if (!(iss >> input)){
		cerr << "Error: String must contain only lowercase letters.";
		return 1;
	}


	//if the input does not contain only lowercase letters, return an error
	if(is_all_lowercase(input) == 0){
		cerr << "Error: String must contain only lowercase letters.";
		return 1;
	}

	//if the input contain letters that are unique return that all letters are unique
	if(all_unique_letters(input)){
		cout << "All letters are unique." << endl;
		return 1;
	}


	//if the input has duplicate letters, return that there are duplicates found
	if(all_unique_letters(input) == 0){
		cout << "Duplicate letters found." << endl;
		return 1;
	}


}













