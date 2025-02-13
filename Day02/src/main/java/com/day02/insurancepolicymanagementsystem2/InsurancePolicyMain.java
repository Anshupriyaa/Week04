package com.day02.insurancepolicymanagementsystem2;

import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyHolder;
    LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolder, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolder = policyHolder;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "PolicyNumber: " + policyNumber + ", Holder: " + policyHolder + ", Expiry: " + expiryDate;
    }
}

class InsurancePolicyManagement {
    private Map<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> sortedPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicies.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies() {
        List<Policy> expiring = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate cutoff = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : sortedPolicies.subMap(today, true, cutoff, true).entrySet()) {
            expiring.addAll(entry.getValue());
        }
        return expiring;
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyHolder.equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = sortedPolicies.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicyMap.remove(policy.policyNumber);
                }
                iterator.remove();
            }
        }
    }

    public void displayPolicies() {
        for (Policy policy : orderedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

public class InsurancePolicyMain {
    public static void main(String[] args) {
        InsurancePolicyManagement ipm = new InsurancePolicyManagement();

        ipm.addPolicy(new Policy("P001", "Anshu priya", LocalDate.now().plusDays(10)));
        ipm.addPolicy(new Policy("P002", "Shamiksha", LocalDate.now().plusDays(40)));
        ipm.addPolicy(new Policy("P003", "Nimish Rathi", LocalDate.now().minusDays(5)));

        System.out.println("All Policies:");
        ipm.displayPolicies();

        System.out.println("\nPolicies expiring in the next 30 days:");
        System.out.println(ipm.getExpiringPolicies());

        System.out.println("\nPolicies of John Doe:");
        System.out.println(ipm.getPoliciesByHolder("John Doe"));

        System.out.println("\nRemoving expired policies...");
        ipm.removeExpiredPolicies();

        System.out.println("\nPolicies after removal:");
        ipm.displayPolicies();
    }
}

