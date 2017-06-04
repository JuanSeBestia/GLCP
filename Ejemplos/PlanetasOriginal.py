import sys

def make_link(G, node1, node2):
    if node1 not in G:
        G[node1] = {}
    (G[node1])[node2] = 1
    if node2 not in G:
        G[node2] = {}
    (G[node2])[node1] = 1
    return G 

def bfs(G, planetas, nodo, V):
    V[nodo] = 0
    cola = [nodo]
    puntos = planetas[nodo]
    while cola != []:
        nodo_actual = cola.pop(0)
        if V[nodo_actual] == 0:
            for vecino in G[nodo_actual]:
                if vecino not in V:
                    V[vecino] = 0
                    cola.append(vecino)
                    puntos += planetas[vecino]
            V[nodo_actual] = 1
    return puntos

datos = map(int, sys.stdin.readline().split())

while datos != [0, 0, 0]:
    planetas = {}
    G = {}
    puntos = map(int, sys.stdin.readline().split())
    for i in xrange(0, datos[0]):
        planetas[i] = puntos[i]
        G[i] = {}
    for i in xrange(0, datos[1]):
        nodos = map(int, sys.stdin.readline().split())
        make_link(G, nodos[0], nodos[1])
    for i in xrange(0, datos[2]):
        V = {}
        planeta = int(sys.stdin.readline())
        if planeta >= datos[0]:
            print 0
        else:
            print bfs(G, planetas, planeta, V)
    datos = map(int, sys.stdin.readline().split())