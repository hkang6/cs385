#include <iostream>
#include <sstream>
#include <string>
#include <cstdlib>

using namespace std;


void display_array(int array[], const int length) {
	cout << "[";
	for (int i = 0; i < length; ++i) {
		if (i != 0) {
			cout << ", ";
		}
		cout << array[i];
	}
	cout <<  "]" << endl;
}

void display_pointer_ptr(int array[], const int length) {
	cout << "[";
	for (int *ptr = array, *end = array + length; ptr < end; ++ ptr) {
		if (ptr != array) {
			cout << ", ";
		}
		cout << *ptr;
	}
	cout << "]" << endl;
}

void pass_by_value(int x) {
	x = 10;
}

void pass_by_pointer(int *x) {
	*x = 10;
}

void pass_by_reference(int &x) {
	x = 10;
}

int main(int argc, char * const argv[]) {

	int x = 5, y = 6, *z = &x;
	cout << x << " " << y << endl;
	cout << z << endl;
	cout << *z << endl;
	*z = 7;
	cout << x << " " << y << endl;
	z = &y;
	*z = 7;
	cout << x << " " << y << endl;
	++z;++z;
	cout << z << endl;
	cout << *z << endl;
	z += 30000;
	cout << z << endl;

	int *values = new int[y];
	for (int i = 0; i < y; i++) {
		values[i] = i;
	}
	display_array(values, y);

	x = 5;
	y = 6;
	pass_by_value(x);

	cout << x << " " << y << endl;

	x = 5;
	y = 6;
	pass_by_pointer(&x);

	cout << x << " " << y << endl;


	x = 5;
	y = 6;
	pass_by_reference(x);

	cout << x << " " << y << endl;
	return 0;

}
