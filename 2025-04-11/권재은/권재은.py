import sys
sys.setrecursionlimit(10000)

tree = {} #딕셔너리 key,value 구조

n = int(input())
for i in range(n):
    node, left, right = input().split()
    tree[node] = (left, right)
    
def preorder(node):
    if node == '.':
        return ''
    left, right = tree[node]
    return node + preorder(left) + preorder(right)

def inorder(node):
    if node == '.':
        return ''
    left, right = tree[node]
    return inorder(left) + node + inorder(right)
    
def postorder(node):
    if node == '.':
        return ''
    left, right = tree[node]
    return postorder(left) + postorder(right) + node

print(preorder('A'))
print(inorder('A'))
print(postorder('A'))