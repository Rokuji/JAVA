#include <utility>
#include "Inventory.h"

// Allow the compiler to define the remaining
// comparison operators
using namespace std::rel_ops;

/**
 *
 */
Inventory::Node::Node()
    :data( Item(0, "Air"), 0 )
{
    this->next = nullptr;
}

/**
 *
 */
Inventory::Node::Node( ItemStack s )
    :data(s)
{
    this->next = nullptr;
}

/**
 *
 */
Inventory::Inventory(){
    this->first    = nullptr;
    this->last     = nullptr;
    this->slots    = 10;
    this->occupied = 0;
}

Inventory::Inventory(int x){
     this->first    = nullptr;
    this->last     = nullptr;
    this->slots    = x;
    this->occupied = 0;

}

bool addItems( ItemStack stack ){
       //Start of  the node
       if (this->first == nullptr)
       {
           Node newnode* = new Node(stack);
           newnode = this->first;
           newnode = this->last;
           this->occupied++;
           return true;

       }


   }
