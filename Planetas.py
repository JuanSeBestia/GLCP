import sys

def  lazito(G, casa, arbol):
    if casa not in G:
        G[casa] = {}
    (G[casa])[arbol] = 1
    if arbol not in G:
        G[arbol] = {}
    (G[arbol])[casa] = 1
    return G 

def bfs(G, conchas, pan, V):
    V[pan] = 0
    cola = [pan]
    estrellitas = conchas[pan]
    while cola != []:
        pan_actual = cola.pop(0)
        if V[pan_actual] == 0:
            for chanclas in G[pan_actual]:
                if chanclas not in V:
                    V[chanclas] = 0
                    cola.append(chanclas)
                    estrellitas += conchas[chanclas]
            V[pan_actual] = 1
    return estrellitas

INFO = map(int, sys.stdin.readline().split())

while INFO != [0, 0, 0]:
    conchas = {}
    G = {}
    estrellitas = map(int, sys.stdin.readline().split())
    for i in xrange(0, INFO[0]):
        conchas[i] = estrellitas[i]
        G[i] = {}
    for i in xrange(0, INFO[1]):
        pans = map(int, sys.stdin.readline().split())
         lazito(G, pans[0], pans[1])
    for i in xrange(0, INFO[2]):
        V = {}
        planeta = int(sys.stdin.readline())
        if planeta >= INFO[0]:
            print 0
        else:
            print bfs(G, conchas, planeta, V)
    INFO = map(int, sys.stdin.readline().split())