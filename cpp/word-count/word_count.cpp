#include "word_count.h"
#include <vector>
#include <boost/algorithm/string/split.hpp>
#include <boost/algorithm/string/classification.hpp>
using namespace std;

map<string, int> word_count::words(string input) {
    map<string, int> return_map;
    vector<string> split_strings;
    boost::split(split_strings, input, boost::is_any_of(" "));
    for (auto word : split_strings) {
        return_map[word]++;
    }
    return return_map;
}
