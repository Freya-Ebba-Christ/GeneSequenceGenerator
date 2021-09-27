/*
                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library.  A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.
 */
package genesequencegenerator;

import java.util.*;

/**
 *
 * @author Olaf Christ
 * @email Christ_p@gmx.de
 */
public class GeneSequenceGraph {

    private int sequenceLength = 0;
    private GeneSequenceHelper aGeneSequenceHelper;
    private GeneSequenceGraphNode rootNode = null;
    private HashMap<String, GeneSequenceGraphNode> graphNodeDictionary;
    private int numSymbols = 0;

    public GeneSequenceGraph(int sequenceLength) {
        this.sequenceLength = sequenceLength;
        aGeneSequenceHelper = new GeneSequenceHelper(sequenceLength);
        graphNodeDictionary = new HashMap<String, GeneSequenceGraphNode>();
    }

    public HashMap<String, GeneSequenceGraphNode> getGraphNodeDictionary() {
        return graphNodeDictionary;
    }

    public int getNumSymbols() {
        return numSymbols;
    }

    public void setNumSymbols(int value) {
        numSymbols = value;
    }

    public void setVisited(boolean value) {
        for (GeneSequenceGraphNode node : graphNodeDictionary.values()) {
            node.setVisited(value);
        }
    }

    public void setVisited(LinkedList<AbstractGraphNode> listOfNodes, boolean value) {
        for (AbstractGraphNode node : listOfNodes) {
            node.setVisited(value);
        }
    }

    public GeneSequenceHelper getGeneSequenceHelper() {
        return aGeneSequenceHelper;
    }

    public int getSequenceLength() {
        return sequenceLength;
    }

    public GeneSequenceGraphNode getNode(String label) {
        return graphNodeDictionary.get(label);
    }

    public boolean checkMutations(LinkedList<String> listOfGenes, int minMutations, boolean verbose) {
        for (String gene_a : listOfGenes) {
            for (String gene_b : listOfGenes) {
                int numDifferences = getGeneSequenceHelper().getNumDifferences(gene_a, gene_b);
                if (numDifferences != 0 && numDifferences < minMutations) {
                    return false;
                } else if (verbose) {
                    if (numDifferences != 0) {
                        System.out.println(gene_a + " " + gene_b + " " + numDifferences);
                    }
                }
            }
        }
        return true;
    }

    public LinkedList<String> getNextNodes(String nodeName, LinkedList<String> listOfNodeNames) {
        GeneSequenceGraphNode aNode = getNode(nodeName);
        LinkedList<AbstractGraphNode> neighbours = aNode.getNeighbours(true);
        this.setVisited(neighbours, true);
        aNode.setVisited(true);
        LinkedList<AbstractGraphNode> neighbours_of_neighbours = aNode.getNeighboursOfNeighbours(neighbours, true);
        setVisited(neighbours_of_neighbours, true);
        LinkedList<AbstractGraphNode> neighbours_of_neighbours_of_neighbours = aNode.getNeighboursOfNeighbours(neighbours_of_neighbours, true);

        for (AbstractGraphNode node : neighbours_of_neighbours_of_neighbours) {
            listOfNodeNames.add(node.getName());
            if (checkMutations(listOfNodeNames, 3, false) == false) {
                listOfNodeNames.removeLast();
            }
        }
        return listOfNodeNames;
    }

    public void build() {
        rootNode = new GeneSequenceGraphNode(getSequenceLength());
        String startNodeString = new String(getGeneSequenceHelper().makeString(rootNode.getGeneSequence()));
        rootNode.setName(startNodeString);
        numSymbols = getGeneSequenceHelper().getSymbols().size();
        getGraphNodeDictionary().put(startNodeString, rootNode);
        addChildNodes(rootNode);
        GeneSequenceGraphNode currentNode = rootNode;
        LinkedList<AbstractGraphNode> listOfNodes = new LinkedList<AbstractGraphNode>();
        listOfNodes.addAll(currentNode.getChildNodes());

        while (listOfNodes.size() != 0) {
            currentNode = (GeneSequenceGraphNode) listOfNodes.removeFirst();
            addChildNodes(currentNode);
            listOfNodes.addAll(currentNode.getChildNodes());
        }

        for (GeneSequenceGraphNode node : getGraphNodeDictionary().values()) {

            if (node.isLeafNode()) {
                for (int n = 0; n < getSequenceLength(); n++) {
                    for (int k = 0; k < getNumSymbols() - 1; k++) {
                        List<Integer> childNodeGeneSequence = null;
                        String childNodenameString = null;
                        List<Integer> parentNodeGeneSequence = new LinkedList< Integer>(node.getGeneSequence());
                        for (int i = 0; i < k + 1; i++) {
                            childNodeGeneSequence = getGeneSequenceHelper().mutate(parentNodeGeneSequence, n);
                            LinkedList<Integer> copyOfchildNodeGeneSequence = new LinkedList<Integer>(childNodeGeneSequence);
                            childNodenameString = new String(getGeneSequenceHelper().makeString(copyOfchildNodeGeneSequence));
                        }
                        GeneSequenceGraphNode childNode = getGraphNodeDictionary().get(childNodenameString);
                        node.addChildNode(childNode);
                    }
                }
            }
        }
    }

    public void traverse_graph() {
        LinkedList<GeneSequenceGraphNode> queue = new LinkedList<GeneSequenceGraphNode>();
        GeneSequenceGraphNode currentNode = null;
        queue.add(rootNode);
        while (queue.size() != 0) {
            currentNode = queue.removeFirst();
            if (currentNode.isVisited() == false) {
                LinkedList<AbstractGraphNode> list_of_neighbours = currentNode.getNeighbours(false);
                for (AbstractGraphNode neighbourNode : list_of_neighbours) {
                    System.out.println(currentNode.getName() + " " + neighbourNode.getName());
                    queue.add((GeneSequenceGraphNode) neighbourNode);
                }
                currentNode.setVisited(true);
            }
        }
        setVisited(false);
    }

    private boolean addChildNodes(GeneSequenceGraphNode graphNode) {
        boolean nodesAdded = false;
        List<Integer> childNodeGeneSequence = null;
        if (graphNode.isLeafNode()) {
            for (int n = 0; n < getSequenceLength(); n++) {
                for (int k = 0; k < getNumSymbols() - 1; k++) {
                    GeneSequenceGraphNode childNode = new GeneSequenceGraphNode(getSequenceLength());
                    childNode.setParentNode(graphNode);
                    List<Integer> parentNodeGeneSequence = new LinkedList< Integer>(graphNode.getGeneSequence());
                    for (int i = 0; i < k + 1; i++) {
                        childNodeGeneSequence = getGeneSequenceHelper().mutate(parentNodeGeneSequence, n);
                    }
                    childNode.setGeneSequence(childNodeGeneSequence);
                    LinkedList<Integer> copyOfchildNodeGeneSequence = new LinkedList<Integer>(childNodeGeneSequence);
                    String childNodenameString = new String(getGeneSequenceHelper().makeString(copyOfchildNodeGeneSequence));
                    childNode.setName(childNodenameString);
                    if (getGraphNodeDictionary().containsKey(childNodenameString) == false) {
                        childNode.setVisited(false);
                        getGraphNodeDictionary().put(childNodenameString, childNode);
                        graphNode.addChildNode(childNode);
                        nodesAdded = true;
                    }
                }
            }
        }
        return nodesAdded;
    }
}
