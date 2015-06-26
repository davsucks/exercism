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
#include <boost/algorithm/string/trim.hpp>
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
    string stripped_input = boost::trim_copy(input);
    if (stripped_input.empty()) {
        return "Fine. Be that way!";
    } else if (no_lowercase_chars_in(stripped_input) && 
               any_alpha_chars_in(stripped_input))
        return "Whoa, chill out!";
    else if (stripped_input.back() == '?')
        return "Sure.";
    return "Whatever.";
}
