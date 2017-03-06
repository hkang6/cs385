/*******************************************************************************
 * Name        : sieve.cpp
 * Author      : Harkirat Kang
 * Date        : Feb 6th
 * Description : Sieve of Eratosthenes
 * Pledge      : I pledge my honor that I have abided by the Stevens Honor System
 ******************************************************************************/

#include <cmath>
#include <iomanip>
#include <iostream>
#include <sstream>


using namespace std;


//Class that allows user to enter a limit so the program can find the primes up to that limit and then displays the primes in an orderly fashion
class PrimesSieve {
public:
    PrimesSieve(int limit): is_prime_(new bool[limit + 1]), limit_(limit) {
        sieve();
        num_primes_ = count_num_primes();
        display_primes();
    }

    ~PrimesSieve() {
        delete [] is_prime_;
    }
    //returns the number of primes found
    inline int num_primes() const {
        return num_primes_;
    }

    void display_primes() const {
        // TODO: write code to display the primes in the format specified in the
        // requirements document.

    	const int max_prime_width = num_digits(max_prime_),
    	primes_per_row = 80 / (max_prime_width + 1);

    	int count = 0;

		cout << endl;
		cout << "Number of primes found: " << num_primes() << endl;
		cout << "Primes up to " <<  limit_ << ":" << endl;

		//format primes found to display using the correct width
		for(int i = 2; i <= limit_; i++){


			if(is_prime_[i] && num_primes() <= 25 && i == max_prime_) {
				cout << i;
				return;
			}
			else if(is_prime_[i] && num_primes() <= 25){
				cout << i << " ";
			}

			else if(i == max_prime_){
				cout << setw(max_prime_width);
				cout << i << endl;
				return;
			}

			else if(is_prime_[i] && count == primes_per_row - 1){
				cout << setw(max_prime_width);
				cout << i << endl;
				count = 0;
			}

			else if(is_prime_[i]){
				cout << setw(max_prime_width);
				cout << i << " ";
				count++;
			}
		}

		cout << endl;


   }


private:
    bool * const is_prime_;
    const int limit_;
    int num_primes_, max_prime_;

    int count_num_primes() const {
        // TODO: write code to count the number of primes found
    	int primes = 0;


    	for(int i = 0; i <= limit_; i++){
        	if(is_prime_[i]){
        		primes++;
        	}
        }

        return primes;
    }

    int num_digits(int num) const {
        // TODO: write code to determine how many digits are in an integer
        // Hint: No strings are needed. Keep dividing by 10.
    	int digits = 0;


    	for(int i = num; i>=1; i /= 10){
    		digits++;
    	}

    	return digits;
    }

    //Sieves algorithm: Finds primes using sieve of Eratosthenes
    void sieve() {
        // TODO: write sieve algorithm
    	is_prime_[1] = false;

    	is_prime_[0] = false;



    	for(int i = 2; i <= limit_; i++){
    	    is_prime_[i] = true;
    	}

    	for (int i = 2; i <= sqrt(double(limit_)); i++){
    		if(is_prime_[i]){
    			for(int j = pow(double(i),2.0);  j <= limit_ ;j += i){
    				is_prime_[j] = false;
    			}
    		}
    	}

    	for(int i = limit_; i >= 2; i--){
    		if(is_prime_[i]){
    			max_prime_ = i;
    			break;
    		}
    	}
    }
};

int main(void) {
    cout << "**************************** " <<  "Sieve of Eratosthenes" <<
            " ****************************" << endl;
    cout << "Search for primes up to: ";
    string limit_str;
    cin >> limit_str;
    int limit;

    // Use stringstream for conversion. Don't forget to #include <sstream>
    istringstream iss(limit_str);

    // Check for error.
    if ( !(iss >> limit) ) {
        cerr << "Error: Input is not an integer." << endl;
        return 1;
    }
    if (limit < 2) {
        cerr << "Error: Input must be an integer >= 2." << endl;
        return 1;
    }

    // TODO: write code that uses your class to produce the desired output.
    PrimesSieve((int)limit);
}
