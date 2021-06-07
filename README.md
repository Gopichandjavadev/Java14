# Java14

1. Incubating Features
	These are the non-final APIs and tools that the Java team comes up with, and provides us for experimentation. They are different from preview features and are provided as separate modules in the package jdk.incubator.

1.1. Foreign Memory Access API (JEP 370)
	This is a new API to allow Java programs to access foreign memory, such as native memory, outside the heap in a safe and efficient manner.
	
	Many Java libraries such as mapDB and memcached do access foreign memory and it was high time the Java API itself offered a cleaner solution. With this intention, the team came up with this JEP as an alternative to its already existing ways to access non-heap memory – ByteBuffer API and sun.misc.Unsafe API.
	
	Built upon three main abstractions of MemorySegment, MemoryAddress and MemoryLayout, this API is a safe way to access both heap and non-heap memory.

1.2. Packaging Tool (JEP 343)
	Traditionally, to deliver Java code, an application developer would simply send out a JAR file that the user was supposed to run inside their own JVM.
	
	However, users rather expected an installer that they'd double click to install the package on their native platforms, such as Windows or macOS.
	
	This JEP aims to do precisely that. Developers can use jlink to condense the JDK down to the minimum required modules, and then use this packaging tool to create a lightweight image that can be installed as an exe on Windows or a dmg on a macOS.


2. JVM/HotSpot Features
2.1. ZGC on Windows (JEP 365) and macOS (JEP 364) – Experimental
	The Z Garbage Collector, a scalable, low-latency garbage collector, was first introduced in Java 11 as an experimental feature. But initially, the only supported platform was Linux/x64.
	
	After receiving positive feedback on ZGC for Linux, Java 14 has ported its support to Windows and macOS as well. Though still an experimental feature, it's all set to become production-ready in the next JDK release.

2.2. NUMA-Aware Memory Allocation for G1 (JEP 345)
	Non-uniform memory access (NUMA) was not implemented so far for the G1 garbage collector, unlike the Parallel collector.
	
	Looking at the performance improvement that it offers to run a single JVM across multiple sockets, this JEP was introduced to make the G1 collector NUMA-aware as well.
	
	At this point, there's no plan to replicate the same to other HotSpot collectors.

2.3. JFR Event Streaming (JEP 349)
	With this enhancement, JDK's flight recorder data is now exposed so that it can be continuously monitored. This involves modifications to the package jdk.jfr.consumer so that users can now read or stream the recording data directly.

3. Deprecated or Removed Features
	Java 14 has deprecated a couple of features:
	
	Solaris and SPARC Ports (JEP 362) – because this Unix operating system and RISC processor are not in active development since the past few years
	ParallelScavenge + SerialOld GC Combination (JEP 366) – since this is a rarely used combination of GC algorithms, and requires significant maintenance effort
	There are a couple of removals as well:
		Concurrent Mark Sweep (CMS) Garbage Collector (JEP 363) – deprecated by Java 9, this GC has been succeeded by G1 as the default GC. Also, there are other more performant alternatives to use now, such as ZGC and Shenandoah, hence the removal
		Pack200 Tools and API (JEP 367) – these were deprecated for removal in Java 11, and now removed
