/** === bob.h ===

#ifndef BOB_H
#define BOB_H 

#include<string>

class bob {

public:
    static std::string hey(std::string);
};

#endif // BOB_H

**/

#include "bob.h"
#include <regex>
#include <string>
#include <algorithm>
using namespace std;

bool no_lowercase_chars_in(const string& input) {
    return find_if(input.begin(), input.end(),
        [](char c){ return islower(c); }) == input.end(); 
}

bool any_alpha_chars_in(const string& input) {
    return find_if(input.begin(), input.end(), 
        [](char c) { return isalpha(c); }) != input.end();
}

string bob::hey(string input) {
    if (no_lowercase_chars_in(input) && any_alpha_chars_in(input))
        return "Whoa, chill out!";
    else if (input.back() == '?')
        return "Sure.";
    return "Whatever.";
}
