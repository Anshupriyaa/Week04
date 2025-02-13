package com.day02.insurancepolicymanagementsystem1;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDate;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + "', Holder='" + policyHolderName +
                "', Expiry=" + expiryDate + ", Type='" + coverageType +
                "', Premium=" + premiumAmount + "}";
    }
}

class InsurancePolicyManager {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        for (InsurancePolicy policy : hashSetPolicies) {
            System.out.println(policy);
        }
    }

    public void displayExpiringSoon() {
        LocalDate today = LocalDate.now();
        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        for (InsurancePolicy policy : treeSetPolicies) {
            if (ChronoUnit.DAYS.between(today, policy.getExpiryDate()) <= 30) {
                System.out.println(policy);
            }
        }
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        for (InsurancePolicy policy : hashSetPolicies) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }

    public void findDuplicatePolicies() {
        Set<String> seen = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        for (InsurancePolicy policy : linkedHashSetPolicies) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }

    public void comparePerformance() {
        int numPolicies = 10000;
        List<InsurancePolicy> policyList = new ArrayList<>();
        for (int i = 0; i < numPolicies; i++) {
            policyList.add(new InsurancePolicy("P" + i, "Holder" + i, LocalDate.now().plusDays(i % 365), "Health", 5000 + (i % 1000)));
        }

        measurePerformance("HashSet", new HashSet<>(), policyList);
        measurePerformance("LinkedHashSet", new LinkedHashSet<>(), policyList);
        measurePerformance("TreeSet", new TreeSet<>(), policyList);
    }

    private void measurePerformance(String setType, Set<InsurancePolicy> set, List<InsurancePolicy> policies) {
        long startTime, endTime;

        startTime = System.nanoTime();
        set.addAll(policies);
        endTime = System.nanoTime();
        System.out.println(setType + " - Add Time: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        set.contains(policies.get(5000));
        endTime = System.nanoTime();
        System.out.println(setType + " - Search Time: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        set.remove(policies.get(5000));
        endTime = System.nanoTime();
        System.out.println(setType + " - Remove Time: " + (endTime - startTime) + " ns");
    }
}

public class InsurancePolicyMain {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        manager.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        manager.addPolicy(new InsurancePolicy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 6000));
        manager.addPolicy(new InsurancePolicy("P003", "Charlie", LocalDate.now().plusDays(20), "Home", 5500));
        manager.addPolicy(new InsurancePolicy("P004", "Dave", LocalDate.now().plusDays(5), "Health", 5200));
        manager.addPolicy(new InsurancePolicy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 5000)); // Duplicate

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Health");
        manager.findDuplicatePolicies();

        System.out.println("\nPerformance Comparison:");
        manager.comparePerformance();
    }
}

