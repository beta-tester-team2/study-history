#include <cstdio>
#include <vector>
using std::vector;
struct Node { char left, right; };

// 전위 순회
void preOrder(vector<Node> &tree, char node) {
    if (node == '.') return;
    printf("%c", node);
    preOrder(tree, tree[node].left);
    preOrder(tree, tree[node].right);
}

// 중위 순회
void inOrder(vector<Node> &tree, char node) {
    if (node == '.') return;
    inOrder(tree, tree[node].left);
    printf("%c", node);
    inOrder(tree, tree[node].right);
}

// 후위 순회
void postOrder(vector<Node> &tree, char node) {
    if (node == '.') return;
    postOrder(tree, tree[node].left);
    postOrder(tree, tree[node].right);
    printf("%c", node);
}

int main() {
    int N;
    // Parent, Left, Right
    char P, L, R;
    vector<Node> tree('Z'); // 트리 노드 배열
    scanf("%d", &N);
    for (int i = 0; i < N; i++) {
        // 노드 생성
        scanf(" %c %c %c", &P, &L, &R);
        tree[P] = { L, R };
    }
    preOrder(tree, 'A'); printf("\n");
    inOrder(tree, 'A'); printf("\n");
    postOrder(tree, 'A');
}