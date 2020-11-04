package it.unibo.oop.lab06.generics1;


import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class GraphImpl<N> implements Graph<N>{

	private Set<N> nodes;
	private  Set<Pair<N,N>> edges ;
	
	public GraphImpl() {
		this.nodes = new HashSet<>();
		this.edges = new HashSet<>();
	}

	public void addNode(N node) {
		this.nodes.add(node);
	}
	
	public void addEdge(N source, N target) {
		if (this.nodes.contains(source) &&	this.nodes.contains(target)) {
				this.edges.add(new Pair<>(source,target));
		}
	}

	public Set<N> nodeSet() {
		return Collections.unmodifiableSet(this.nodes);
	}

	public Set<N> linkedNodes(N node) {
		Set<N> linked = new HashSet<>();
		for(Pair<N,N> p : edges) {
			if(p.getFirst().equals(node) ) {
				linked.add(p.getSecond());
			}
			if(p.getSecond().equals(node)) {
				linked.add(p.getFirst());
			}
		}
		return linked;
	}

	public List<N> getPath(N source, N target) {
		List<N> linkedList = new LinkedList<N>();
			for (Pair<N,N> p : this.edges) {
				pickSource(source, linkedList, p);
				pickLinkedNode(target, linkedList, p);
		}
		linkedList.add(target);
		return linkedList;
	}

	private void pickLinkedNode(N target, List<N> linkedList, Pair<N, N> p) {
		if(!isTarget(target, linkedList, p.getFirst()) && 
				linkedList.isEmpty() && !isNodeRepeated(linkedList,p.getFirst())) {
			linkedList.add(p.getFirst());
		}else if(!isTarget(target,linkedList,p.getSecond()) &&
					!linkedList.isEmpty() && !isNodeRepeated(linkedList,p.getSecond())) {
				linkedList.add(p.getSecond());
		}
	}

	private void pickSource(N source, List<N> linkedList, Pair<N, N> p) {
		if(isSource(source, linkedList, p.getFirst()) && 
				!isNodeRepeated(linkedList,p.getFirst())) {
			linkedList.add(p.getFirst());
		}
		else if(isSource(source,linkedList,p.getSecond()) &&
					!isNodeRepeated(linkedList,p.getSecond())) {
				linkedList.add(p.getSecond());
		}
	}

	private boolean isSource(N source, List<N> linkedList, N p) {
		return p.equals(source);
	}
	
	private boolean isTarget(N target, List<N> linkedList, N p) {
		return p.equals(target);
	}
	
	private boolean isNodeRepeated(List<N> linkedList, N element) {
		return linkedList.contains(element);
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphImpl other = (GraphImpl) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (nodes == null) {
			if (other.nodes != null)
				return false;
		} else if (!nodes.equals(other.nodes))
			return false;
		return true;
	}

	
	public String toString() {
		return "GraphImpl [nodes=" + this.nodes + ", edges=" + this.edges + "]";
	}
	
	

	
	

	
	
	
}


