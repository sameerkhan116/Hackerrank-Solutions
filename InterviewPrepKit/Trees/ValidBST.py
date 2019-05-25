""" Node is defined as
class node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
"""

def checkBST(root):
    return checkBSTHelper(root, float('-inf'), float('inf'))

def checkBSTHelper(root, a, b):
    if(root is None):
        return True
    if(root.data <= a or root.data >= b):
        return False
    return checkBSTHelper(root.left, a, root.data) and checkBSTHelper(root.right, root.data, b)