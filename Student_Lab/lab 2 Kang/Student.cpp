
//harkirat kang
//i pledge my honor that i have abided by the stevens honor system

#include <string>
#include <iostream>
#include <sstream>
#include <vector>
#include <iomanip>

using namespace std;

class Student {
private:
	string first_;
	string last_;
	float gpa_;
	int id_;
public:
	Student (string f, string l, float g, int i) {
		first_ = f;
		last_ = l;
		gpa_ = g;
		id_ = i;

	}
	void set_first(string f) {
		first_ = f;

	}
	string get_first() const{
		return first_;
	}

	void set_last(string l) {
		last_ = l;
	}
	string get_last() const{
		return last_;
	}
	void set_gpa(float g) {
		gpa_ = g;
	}
	float gpa() const{
		return gpa_;
	}
	void set_id(int i) {
		id_ = i;
	}
	int id() const{
		return id_;
	}
	string full_name() const{
		return get_first() + " " + get_last();
	}
	void print_info() const{
		cout << full_name() << ", GPA: " << setprecision(2) << fixed << gpa() << ", ID: " << id() << endl;

	}

};

vector<Student> find_failing_students(const vector<Student> &students) {
	// Always make sure you use the pre-increment operator when working with // iterators. Declare iterator inside loop to reduce its scope.

	vector<Student> failing_students;
	for (vector<Student>::const_iterator it = students.begin();it != students.end(); ++it) {
		if (it -> gpa () < 1.0){
			failing_students.push_back(*it);
		}
	// Use .push_back(*it) to add a student to the vector if his or her gpa is // less than 1.0.
	// Remember 'it' is a pointer, so in order to get the gpa, you must use '->' // instead of '.'
	}
	return failing_students;

}

void print_students(const vector<Student> &students) {
	for (vector<Student>::const_iterator it = students.begin(); it != students.end(); ++it){
		it -> print_info();
	}
	// Same way we iterated through the vector in the previous function, except
	// calling print_info() for each student
}

/**
* Allows the user to enter information for multiple students, then * find those students whose GPA is below 1.0 and prints them to the * screen.
*/
int main() {
	string first_name, last_name;
	float gpa;
	int id;
	char repeat;
	vector<Student> students;
	do {
		cout << "Enter student's first name: "; cin >> first_name;
		cout << "Enter student's last name: "; cin >> last_name;
		gpa = -1;
		while (gpa < 0 || gpa > 4) {
            cout << "Enter student's GPA (0.0-4.0): ";
            cin >> gpa;
		}
		cout << "Enter student's ID: ";
		cin >> id;
		students.push_back(Student(first_name, last_name, gpa, id));
		cout << "Add another student to database (Y/N)? ";
		cin >> repeat;
	}
	while (repeat == 'Y' || repeat == 'y');
	cout << endl << "All students:" << endl;
    print_students(students);
    cout << endl << "Failing students:";

    if(find_failing_students(students).size() == 0){
    	cout << " " << "None" << endl;
    }
    cout << endl;
    print_students(find_failing_students(students));

    return 0;
}

