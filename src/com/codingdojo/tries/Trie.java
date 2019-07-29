package com.codingdojo.tries;

public class Trie {
	   public Node root;
	    
	    public Trie() {
	        this.root = new Node();
	    }
	    
	    public void insertWord(String word) {
	        // gets the root node;
	        Node currentNode = this.root;
	        
	        // iterates over every character in the word
	        for(int i = 0; i < word.length(); i++) {
	            // currentLetter is just the character / letter at the iteration
	            Character currentLetter = word.charAt(i);
	            // ask if the current letter is in the map of the current node
	            Node child = currentNode.children.get(currentLetter);
	            if(child == null) {
	                child = new Node();
	                currentNode.children.put(currentLetter, child); 
	            } 
	            
	            currentNode = child;
	        }
	        currentNode.isCompleteWord = true;
	    }
	    
	    public boolean isPrefixValid(String prefix) {
	    	Node currentNode = this.root;
	    	System.out.println("This checks for: " + prefix);
	    	for (int i = 0; i < prefix.length(); i++) {
	    		Character currentLetter = prefix.charAt(i);
	    		Node child = currentNode.children.get(currentLetter);
	    		currentNode = child;
	    		if(child == null) {
	    			return false;
	    		}
	    	}
    		return true;
	    }
	    
	    public boolean isWordValid (String word) {
	    	Node currentNode = this.root;
	    	System.out.println("Checking: "+word);
	    	for (int  i = 0; i < word.length(); i++) {
				Character currentLetter= word.charAt(i);			
				Node child = currentNode.children.get(currentLetter);
				currentNode = child;				
				if (child==null) {
					return false;
			}
		}

			return currentNode.isCompleteWord;
	    }
	    
	    public void traverse(Node node) {
	    	for(Character key: node.children.keySet()) {
	    		System.out.println(key);
	    		Node child = node.children.get(key);
	    		if(child == null) {
	    			return;
	    		}
	    		traverse(child);
	    	}
	    }
	    	
	    
	    public void printAllKeys() {
	    	traverse(this.root);
	    }

}
