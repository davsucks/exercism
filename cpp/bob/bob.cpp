#include "bob.h"
#include <regex>
#include <string>
using namespace std;

// TODO: pass 1, 2, 3
string bob::hey(string input) {
    if (regex_match(input, regex("^[^a-z]*")))
        return "Whoa, chill out!";
    else if (input.back() == '?')
        return "Sure.";
    return "Whatever.";
}
