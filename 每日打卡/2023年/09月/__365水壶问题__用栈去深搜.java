package 西湖算法题解___中等题;

import java.util.*;

/**
 * @author 25678
 */
public class __365水壶问题__用栈去深搜 {
	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		/**
		 在任意一个时刻，我们可以且仅可以采取以下几种操作：
			 把 X 壶的水灌进 Y 壶，直至灌满或倒空；
			 把 Y 壶的水灌进 X 壶，直至灌满或倒空；
			 把 X 壶灌满；
			 把 Y 壶灌满；
			 把 X 壶倒空；
			 把 Y 壶倒空。


		 */

		Deque<int[]> stack = new LinkedList<>();
		//所以要用Deque实现栈stack，那么必然是要继承LinkedList；
		/*
		`Deque`（双端队列）是Java集合框架中的接口，用于表示一个可以在两端进行插入和删除操作的数据结构。`ArrayDeque`和`LinkedList`都实现了`Deque`接口，但它们在内部实现和性能方面有一些不同之处。

1. **内部实现方式**:
   - `ArrayDeque`: 内部使用动态数组（循环数组）来存储元素。它通过在数组的两端保留指针来实现双端操作。当数组满时，它会自动进行扩展，以适应更多的元素。由于数组具有连续内存分配，因此在内存访问方面可能更加高效。

   - `LinkedList`: 内部使用双向链表来存储元素。每个元素都有指向前一个和后一个元素的引用。这使得在链表中插入和删除元素比较高效，但在随机访问元素时可能会较慢，因为需要遍历链表。

2. **性能差异**:
   - `ArrayDeque`: 由于其基于数组的内部实现，`ArrayDeque` 在随机访问和元素存取时可能更快，因为数组支持直接索引。另外，由于数组分配的内存是连续的，它可能在缓存方面也具有一些优势，从而提供更好的性能。

   - `LinkedList`: `LinkedList` 在插入和删除元素时比较高效，特别是在列表中间插入或删除元素。然而，由于需要遍历链表来访问元素，随机访问的性能相对较差。

在选择使用哪种实现时，您需要根据您的特定需求权衡优劣。如果您需要频繁进行插入和删除操作，并且不太关心随机访问性能，`LinkedList` 可能更适合。如果您需要高效的随机访问和高性能的双端操作，`ArrayDeque` 可能是更好的选择。

另外，需要注意的是，`ArrayDeque` 在大多数情况下会比 `LinkedList` 具有更好的性能，因为它在实现中更接近内存的布局和硬件缓存行的优化。但是具体的性能表现还会受到其他因素的影响，如具体使用场景、元素数量等。
		 */
		stack.push(new int[]{0,0});
		//1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106
		Set<Long> seen = new HashSet<Long>();
		while (!stack.isEmpty()){
			if (seen.contains(hash_state(stack.peek()))){
				stack.pop();
				continue;
			}
			seen.add(hash_state(stack.peek()));
			int [] state=stack.pop();
			int remain_x = state[0],remain_y = state[1];
			if (remain_x == targetCapacity || remain_y == targetCapacity || remain_y +remain_x == targetCapacity){
				return true;
			}
			//每次都对水壶执行如下操作：
//			把 X 壶的水灌进 Y 壶，直至灌满或倒空；
			stack.push(new int[]{jug1Capacity,remain_y});
//			把 Y 壶的水灌进 X 壶，直至灌满或倒空；
			stack.push(new int[]{remain_x,jug2Capacity});
//			把 X 壶灌满；
			stack.push(new int[]{0,remain_y});
//			把 Y 壶灌满；
			stack.push(new int[]{remain_x,0});
//			把 X 壶倒空；
			stack.push(new int[]{remain_x - Math.min(remain_x,jug2Capacity - remain_y),remain_y + Math.min(remain_x,jug2Capacity - remain_y)});
//			把 Y 壶倒空。
			stack.push(new int[]{remain_x + Math.min(remain_y ,jug1Capacity - remain_x),remain_y - Math.min(remain_y,jug1Capacity - remain_x)});
		}
		return false;
	}

	private Long hash_state(int[] peek) {
		return (long)peek[0]*1000001 + peek[1];
	}
}
