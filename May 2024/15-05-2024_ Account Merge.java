

// User function Template fo
class Solution {
public:
    vector<vector<string>> accountsMerge(vector<vector<string>> &accounts) {
        unordered_map<string, int> emailToIndex;
        unordered_map<int, string> indexToEmail;
        unordered_map<int, string> indexToName;
        int index = 0;
        
        vector<int> parent(10001);
        iota(parent.begin(), parent.end(), 0);

        function<int(int)> find = [&](int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        };

        auto unionSets = [&](int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY)
                parent[rootX] = rootY;
        };

        for (const auto& account : accounts) {
            const string& name = account[0];
            for (int i = 1; i < account.size(); ++i) {
                const string& email = account[i];
                if (emailToIndex.find(email) == emailToIndex.end()) {
                    emailToIndex[email] = index;
                    indexToEmail[index] = email;
                    indexToName[index] = name;
                    ++index;
                }
                unionSets(emailToIndex[account[1]], emailToIndex[email]);
            }
        }

        unordered_map<int, vector<string>> rootToEmails;
        for (const auto& emailIndexPair : emailToIndex) {
            int root = find(emailIndexPair.second);
            rootToEmails[root].push_back(emailIndexPair.first);
        }

        vector<vector<string>> mergedAccounts;
        for (auto& rootEmailsPair : rootToEmails) {
            vector<string> emails = move(rootEmailsPair.second);
            sort(emails.begin(), emails.end());
            emails.insert(emails.begin(), indexToName[rootEmailsPair.first]);
            mergedAccounts.push_back(move(emails));
        }

        return mergedAccounts;
    }
};




