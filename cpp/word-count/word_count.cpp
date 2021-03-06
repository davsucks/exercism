#include "word_count.h"
#include <vector>
#include <algorithm>
#include <regex>
#include <iostream>
#include <boost/algorithm/string/split.hpp>
#include <boost/algorithm/string/classification.hpp>
using namespace std;

string remove_punctuation_from(const string& input) {
    string result(regex_replace(input, regex(","), ", ")), empty_string;
    remove_copy_if(result.begin(), result.end(),            
                   back_inserter(empty_string), //Store output           
                   [](char c) { return ispunct(c); });
    return empty_string;
}

string normalize_spaces(const string& input) {
    string temp(regex_replace(input, regex("\\\n"), " "));
    return regex_replace(temp, regex("[' ']{2,}"), " ");
}

string normalize_case(const string& input) {
    string temp(input);
    transform(input.begin(), input.end(), temp.begin(), ::tolower);
    return temp;
}

string normalize_input(const string& input) {
    string temp_string = remove_punctuation_from(input);
    return normalize_case(normalize_spaces(temp_string));
}

map<string, int> word_count::words(string input) {
    map<string, int> return_map;
    vector<string> split_strings;
    string normalized_input = normalize_input(input);
    boost::split(split_strings, normalized_input, boost::is_any_of(" "));
    for (auto word : split_strings) {
        return_map[word]++;
    }
    return return_map;
}
