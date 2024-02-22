package com.example.dsalgo;

import com.example.dsalgo.sorting.Sorting;
import com.example.dsalgo.ch2array.Array;
import com.example.dsalgo.linkedlist.LinkedListPractice;
import com.example.dsalgo.ch4stacks.StackArrayImpl;
import com.example.dsalgo.ch4stacks.StackLinkedListImpl;
import com.example.dsalgo.ch4stacks.StackProblems;
import com.example.dsalgo.ch5queues.QueueLinkedListImpl;
import com.example.dsalgo.ch5queues.QueueProblems;
import com.example.dsalgo.trees.BinaryTree;
import com.example.dsalgo.trees.BinaryTreePractice;
import com.example.dsalgo.dynamicprogramming.DynamicProgrammingProblems;
import com.example.dsalgo.heapsandhashing.HeapHashingProblems;
import com.example.dsalgo.strings.StringProblems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatastructuresAlgorithmsMadeEasyApplication implements CommandLineRunner {

//	@Autowired
//	SinglyLinkedList singlyLinkedList;
//
//	@Autowired
//	DoublyLinkedList doublyLinkedList;

	@Autowired
	StackArrayImpl stackArray;

	@Autowired
	StackLinkedListImpl stackLinkedList;

	@Autowired
	QueueLinkedListImpl queueLinkedList;

	@Autowired
	QueueProblems queueProblems;

	@Autowired
	BinaryTree binaryTree;

	@Autowired
	Sorting sorting;

	@Autowired
	BinaryTreePractice binaryTreePractice;

	@Autowired
	Array arrayProblems;

//	@Autowired
//	LinkedList linkedList;

	@Autowired
	StackProblems stackProblems;

	@Autowired
	StringProblems stringProblems;

	@Autowired
	LinkedListPractice listPractice;

	@Autowired
	HeapHashingProblems heapHashingProblems;

	@Autowired
	DynamicProgrammingProblems dynamicProgrammingProblems;

	public static void main(String[] args) {
		SpringApplication.run(DatastructuresAlgorithmsMadeEasyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

//		int [] arr = {7,5,1};
//		int[] dp = new int[19];
//		Arrays.fill(dp, -1);
//		dp[0] = 0;
//		System.out.println(dynamicProgrammingProblems.minCoinsRecursive(18, arr));
//		System.out.println(dynamicProgrammingProblems.minCoinsDp(18, arr, dp));
//		int[] array = {4,5,2,25};

//		heapHashingProblems.KFrequentNumbers(array, 3);
//		heapHashingProblems.KLargestElements(array, 3);
//		heapHashingProblems.kSort(array, 2);
//		heapHashingProblems.nextGreaterElementStack(array);


//		LinkedListPractice listPractice1 = new LinkedListPractice(9);
//		LinkedListPractice.Node node = new LinkedListPractice.Node(1);
//		LinkedListPractice practice = new LinkedListPractice(node);
//		node.next = new LinkedListPractice.Node(2);
//		node.next.next = new LinkedListPractice.Node(3);
//		node.next.next.next = new LinkedListPractice.Node(4);
//		node.next.next.next.next = new LinkedListPractice.Node(5);
//		listPractice.printList(listPractice.reverseKNodesList(node, 2));
//		listPractice.printList(listPractice.segregateEvenOdd(node));
//		listPractice.printList(listPractice.zigZagList(node));
//		System.out.println(listPractice.removeNthNodeFromEnd(node, 2));
//		listPractice.reOrderListEfficient(node);
//		listPractice.printList(node);
//		LinkedListPractice.NodeWithChildRight root = new LinkedListPractice.NodeWithChildRight(1);
//		root.right = new LinkedListPractice.NodeWithChildRight(2);
//		root.right.right = new LinkedListPractice.NodeWithChildRight(3);
//		root.right.right.right = new LinkedListPractice.NodeWithChildRight(4);
//		root.child = new LinkedListPractice.NodeWithChildRight(5);
//		root.child.right = new LinkedListPractice.NodeWithChildRight(6);
//		root.child.right.child = new LinkedListPractice.NodeWithChildRight(7);
//		listPractice.flattenMultiLevelList(root);
//		listPractice.printMultiLevelList(root);
//		LinkedListPractice.Node	next4NodesHead = node.next.next.next.next;
//		next4NodesHead.next =  new LinkedListPractice.Node(0);
//		next4NodesHead.next.next = new LinkedListPractice.Node(7);
//		LinkedListPractice.Node node1 = new LinkedListPractice.Node(4);
//		node1.next = new LinkedListPractice.Node(5);
//		node1.next.next = new LinkedListPractice.Node(6);
//		listPractice.printList(node);
//		listPractice.removeDuplicatesFromUnsortedListHashmap(node);
//		listPractice.printList(listPractice.sortListOf012s(node));
//		listPractice.printList(node1);
//		listPractice.printList(listPractice.mergeTwoSortedList(node, node1));
//		listPractice.printList(listPractice.mergeTwoSortedListRecursive(node, node1));
//		System.out.println(listPractice.deleteWithoutHeadNode(node).data);
//		listPractice.printList(node);
//		LinkedListPractice.Node head = listPractice.returnHead();
//		node.next.next.next = head;
//		listPractice.printList(head);
//		System.out.println(listPractice.isListCycle(head));
//		System.out.println(listPractice.isListCycleHashMap(head));
//		LinkedListPractice.Node reverseHead = listPractice.reverseList(head);
//		listPractice.printList(reverseHead);

//		LinkedListPractice.DLLNode dllHead = new LinkedListPractice.DLLNode(1);
//		dllHead.next = new LinkedListPractice.DLLNode(2);
//		dllHead.next.next = new LinkedListPractice.DLLNode(3);
//		listPractice.printDoublyLinkedList(dllHead);
//		listPractice.printDoublyLinkedList(listPractice.reverseDoublyLinkedList(dllHead));

//		stringProblems.reverseString("hardeep");
//		stringProblems.reverseStringRecursive("hardeep", 6, "");
//		stringProblems.removeDuplicates("haaeep");
//		stringProblems.removeDuplicatesRecursive("haadeep", 0, "");
//		stringProblems.subsequencesUniqueStringsRecursive("aaa", 0, "");
//		System.out.println(stringProblems.isPalindrome("A man, a plan, a canal: Panama"));
//		System.out.println(stringProblems.isPalindromeRecursive("abcdecba", 0, 6));
//		System.out.println(stringProblems.isAnagram("anagram", "angram"));
//		System.out.println(stringProblems.removeConsecutiveCharacter("accccaaabbb"));
//		System.out.println(stringProblems.longestSubstring("bbbbb"));
//		System.out.println(stringProblems.findLengthOfMaxSubstringByReplacingChar("aabad", 2));
//		String [] strings = {"CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG", "SUED", "LEAN", "SCAR", "DESIGN"};
//		stringProblems.groupAnagrams(strings);
//		stringProblems.countPalindromeSubstrings("abaab");
//		stackProblems.infixToPostfix("2*3+4*(8/(2*2))-9");
//		System.out.println(stackProblems.longestValidString("()())))()"));
//		System.out.println(stackProblems.hasDuplicateParenthesis("(((a+(b))+(c+d)))"));

//		LinkedList.Node head = new LinkedList.Node(1);
//		head.next = new LinkedList.Node(2);
//		head.next.next = new LinkedList.Node(3);
//		head.next.next.next = new LinkedList.Node(4);
//		linkedList.insert(4);
//		linkedList.insert(2);
//		linkedList.insert(1);
//		linkedList.insert(1);
//		linkedList.insert(2);
//		linkedList.printList();
//		linkedList.findNthFromLastRecursive(head, 2);
//		linkedList.removeDuplicatesFromSortedList();
//		linkedList.printList();


		int[] arr = {7,2,5,4,3,1,6};
//		arrayProblems.kthLargestElementBySorting(arr, 2);
		System.out.println(arrayProblems.kthLargestElementByQuickSortPivot(arr, 0, 6, 6));
//		arrayProblems.repeatAndMissingNumberUsingArray(arr);
//		arrayProblems.buySellStock(arr);
//		System.out.println(arrayProblems.chocolateDistributionProblem(arr, 5));
//		System.out.println(arrayProblems.searchElementSortedRotatedArr(arr, 0, 8, 5));
//		System.out.println(arrayProblems.majorityElementSorting(intArray));
//		System.out.println(arrayProblems.majorityElementHashmap(intArray));
//		System.out.println(arrayProblems.majorityElementMooreAlg(intArray));
//		System.out.println(arrayProblems.maxSumOfSubArrayBrute(intArray));
//		System.out.println(arrayProblems.maxSumOfSubArraysKadaneAlg(intArray));
//		arrayProblems.productArrayExceptItselfByDivision(intArray);
//		array.printSubArraysZeroSumHashing(intArray);
//		System.out.println(array.findMinimumRotatedArray(intArray, 0, 4));
//		array.findDuplicates(intArray);
//		array.findDuplicatesWithCounter(intArray);
//		array.positiveEvenNegativeOdd(intArray);
//		array.rearrangeEvenOddNumbers(intArray);
//		array = new Array(arr);
//		array.rearrangePosNegNumbers(intArray);
//		System.out.println(array.peekArray(arr));
//		array.peekElement(arr);
//		array.findMinAndMax(intArray);
//		array.findMinAndMaxPairs(intArray);
//		array.findMinAndMaxTournamentMethod(intArray, 0, 6);
//		int[] arr = {-1,0,-2,4,6,-6};
//		System.out.println(array.maxSumOfSubArrays(arr, 3));
//		array.maxSumOfArraysBruteForce(arr, 3);
//		array.printSubArraysSlidingWindow(arr, 3);
//		array.printFirstNegativeIntBruteForce(arr, 3);
//		array.printFirstNegativeIntSlidingWindow(arr, 3);

//		int[] arr = {7, 5, 3, 8, 10, 1};
//		sorting.bubbleSortDescending(arr);
//		System.out.println();
//		sorting.bubbleSortAscending(arr);
//		sorting.selectionSort(arr);
//		sorting.insertionSort(arr);
//		System.out.println(Arrays.toString(sorting.quickSort(arr, 0, 5)));


//		BinaryTreePractice.Node root = new BinaryTreePractice.Node(1);
//		root.left = new BinaryTreePractice.Node(2);
//		root.right = new BinaryTreePractice.Node(3);
//		root.left.left = new BinaryTreePractice.Node(4);
//		root.left.right = new BinaryTreePractice.Node(5);
//		root.right.left = new BinaryTreePractice.Node(6);
//		root.right.right = new BinaryTreePractice.Node(7);
//		root.right.left.left = new BinaryTreePractice.Node(8);
//		root.right.left.left.left = new BinaryTreePractice.Node(9);
//		root.right.left.left.left.left = new BinaryTreePractice.Node(10);
//		root.right.right.right = new BinaryTreePractice.Node(11);
//		root.right.right.right.right = new BinaryTreePractice.Node(12);
//		root.right.right.right.right.right = new BinaryTreePractice.Node(13);
//		root.right.right.right.right.right.right = new BinaryTreePractice.Node(14);
//		BinaryTreePractice.Node subRoot = new BinaryTreePractice.Node(2);
//		subRoot.left = new BinaryTreePractice.Node(4);
//		subRoot.right = new BinaryTreePractice.Node(5);
//		System.out.println(binaryTreePractice.isSubTree(root, subRoot));
//		System.out.println(binaryTreePractice.findMaxRecursive(root));
//		System.out.println(binaryTreePractice.findElementRecursive(root, 8));
//		System.out.println(binaryTreePractice.deepestNode(root));
//		binaryTreePractice.levelOrderTraversalIterative(binaryTreePractice.mirrorTree(root));
//		System.out.println(binaryTreePractice.diameterTree(root));
//		System.out.println(binaryTreePractice.checkForParentChildrenSum(root));
//		binaryTreePractice.levelOrderTraversalIterative(binaryTreePractice.mirrorTreeRecursive(root));
//		System.out.println(binaryTreePractice.heightOfTreeRecursive(root));
//		System.out.println(binaryTreePractice.isBalanced(root));
//		binaryTreePractice.preOrderTraversalRecursive(root);
//		System.out.println();
//		binaryTreePractice.inOrderTraversalRecursive(root);
//		System.out.println();
//		binaryTreePractice.postOrderTraversalRecursive(root);
//		System.out.println();
//		binaryTreePractice.preOrderTraversalIterative(root);
//		binaryTreePractice.inOrderTraversalIterative(root);
//		binaryTreePractice.postOrderTraversalTwoStacksIterative(root);
//		binaryTreePractice.levelOrderTraversalIterative(root);


//		BinaryTree.Node root1 = new BinaryTree.Node(5);
//		root1.left = new BinaryTree.Node(2);
//		root1.right = new BinaryTree.Node(3);
//		root1.left.left = new BinaryTree.Node(4);
//		root1.left.right = new BinaryTree.Node(5);
//		System.out.println(binaryTree.checkForChildrenSumParent(root1));
//		BinaryTree.Max_Level max = new BinaryTree.Max_Level();
//		binaryTree.topViewTreeInfo(root);
//		binaryTree.bottomViewHashmap(root);
//		binaryTree.bottomViewQueue(root);
//		binaryTree.rightView(root, 1);
//		binaryTree.rightView1(root);
//		binaryTree.leftView(root, 1);
//		binaryTree.leftView1(root);
//		root.right.left = new BinaryTree.Node(6);
//		root.right.right = new BinaryTree.Node(7);
//		root.right.left.left = new BinaryTree.Node(8);
//		root.right.left.left.left = new BinaryTree.Node(4);
//		root.right.left.left.right = new BinaryTree.Node(4);
//		binaryTree.toSumTree(root);
//		binaryTree.inOrderTraversalRecursive(root);
//		BinaryTree.Height height = new BinaryTree.Height();
//		System.out.println(binaryTree.isBalanced(root, height));
//		System.out.println(binaryTree.checkForChildrenSumParent(root));
//		binaryTree.levelOrderTraversal(root);
//		binaryTree.inOrderTraversalNonRecursive(root);
//		System.out.println();
//		binaryTree.mirrorTree(root);
//		System.out.println();
//		binaryTree.levelOrderTraversal(binaryTree.mirrorTreeRecursive(root));
//		binaryTree.preOrderTraversalRecursive(root);
//		System.out.println();
//		binaryTree.preOrderTraversalNonRecursive(root);
//		System.out.println();
//		binaryTree.inOrderTraversalRecursive(root);
//		System.out.println();
//		binaryTree.inOrderTraversalNonRecursive(root);
//		System.out.println();
//		binaryTree.postOrderTraversalRecursive(root);
//		System.out.println();
//		binaryTree.postOrderTraversalNonRecursive(root);
//		System.out.println();
//		binaryTree.levelOrderTraversal(root);
//		System.out.println();
//		System.out.println(binaryTree.heightOfTreeRecursive(root));
//		System.out.println(binaryTree.heightOfTreeUsingStack(root));
//		System.out.println(binaryTree.heightOfTreeUsingLevelOrder(root));
//		System.out.println(binaryTree.sizeOfTreeRecursive(root));
//		System.out.println(binaryTree.sizeOfTreeNonRecursive(root));
//		binaryTree.printReverseLevelOrder(root);
//		binaryTree.deepestNode(root);
//		binaryTree.numberOfLeavesLevelOrder(root);
//		binaryTree.numberOfFullNodesLevelOrder(root);
//		binaryTree.numberOfHalfNodesLevelOrder(root);
//		binaryTree.deleteNode(root, new BinaryTree.Node(7));
//		binaryTree.levelOrderTraversal(root);

//		binaryTree.heightOfTreeUsingLevelOrder();

//		queueLinkedList.enQueue(1);
//		queueLinkedList.enQueue(2);
//		queueLinkedList.enQueue(3);
//		queueLinkedList.printQueue();
//		queueProblems.reverseQueueUsingStack(queueLinkedList);
//		queueLinkedList.printQueue();
//		stackLinkedList = queueProblems.transferQueueToStack(queueLinkedList);
//		stackLinkedList.printStack();


//		stackLinkedList.push(1);
//		stackLinkedList.push(2);
//		stackLinkedList.push(3);
//		stackLinkedList.printStack();
//		System.out.println();
//		System.out.println(stackLinkedList.pop());
//		System.out.println(stackLinkedList.isEmptyStack());
//		System.out.println(stackLinkedList.top());
//		stackLinkedList.printStack();

//		stackArray.push(1);
//		stackArray.push(2);
//		stackArray.push(4);
//		System.out.println(stackArray.isEmptyStack());
//		System.out.println(stackArray.isFullStack());
//		System.out.println(stackArray.top());
//		stackArray.pop();
//		stackArray.printStack();

//		doublyLinkedList.insertAtBeginning(new DoublyLinkedListOperations.Node(1));
//		doublyLinkedList.insertAtBeginning(new DoublyLinkedListOperations.Node(2));
//		doublyLinkedList.insertAtBeginning(new DoublyLinkedListOperations.Node(3));
//		doublyLinkedList.insertAtEnd(new DoublyLinkedListOperations.Node(4));
//		doublyLinkedList.insertAtEnd(new DoublyLinkedListOperations.Node(5));
//		doublyLinkedList.insertAfterGivenNode(new DoublyLinkedListOperations.Node(7), 2);
//		doublyLinkedList.insertBeforeGivenNode(new DoublyLinkedListOperations.Node(6), 2);
//		System.out.println(doublyLinkedList.deleteFromBeginning().data);
//		System.out.println(doublyLinkedList.deleteFromEnd().data);
//		System.out.println(doublyLinkedList.deleteAfterGivenNode(4).data);
//		doublyLinkedList.printList();
//		singlyLinkedList.insertAtBeginning(new SinglyLinkedListOperations.Node(1));
//		singlyLinkedList.insertAtBeginning(new SinglyLinkedListOperations.Node(2));
//		singlyLinkedList.insertAtBeginning(new SinglyLinkedListOperations.Node(3));
//		singlyLinkedList.printList();
//		singlyLinkedList.deleteFromBeginning();
//		singlyLinkedList.printList();
//		singlyLinkedList.insertAtEnd(new SinglyLinkedListOperations.Node(3));
//		singlyLinkedList.insertAtEnd(new SinglyLinkedListOperations.Node(4));
//		singlyLinkedList.insertInMiddle(new SinglyLinkedListOperations.Node(4));
//		singlyLinkedList.insertInMiddle(new SinglyLinkedListOperations.Node(7));
//		singlyLinkedList.insertInMiddle(new SinglyLinkedListOperations.Node(8));
//		singlyLinkedList.deleteFromBeginning();
//		singlyLinkedList.deleteFromEnd();
//		singlyLinkedList.deleteFromMiddle();
//		singlyLinkedList.printList();
	}

}
