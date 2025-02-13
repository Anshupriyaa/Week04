package com.day02.votingsystem;

import java.util.*;

public class VotingSystem {
    private Map<String, Integer> voteCount;
    private LinkedHashMap<String, Integer> voteOrder;

    public VotingSystem() {
        voteCount = new HashMap<>();
        voteOrder = new LinkedHashMap<>();
    }

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteCount.get(candidate));
    }

    public void displayResults() {
        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);
        System.out.println("Sorted Results (Alphabetical Order): " + sortedResults);
        System.out.println("Vote Order (Sequence of Votes Cast): " + voteOrder);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Anshu");
        system.castVote("Shamiksha");
        system.castVote("Nimish");
        system.castVote("Mohan");
        system.castVote("Nishu");
        system.castVote("Ankit");

        system.displayResults();
    }
}

