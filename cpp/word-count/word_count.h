#ifndef WORD_COUNT_H
#define WORD_COUNT_H

#include <string>
#include <map>

class word_count {
public:
    static std::map<std::string, int> words(std::string input);
};

#endif // WORD_COUNT_H
