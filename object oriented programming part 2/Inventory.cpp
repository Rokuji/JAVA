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

Inventory::Inventory( int n){
    this->first = nullptr;
    this->last = nullptr;
    this->slots = n;
    this->occupied = 0;


}
bool Inventory::addItems( ItemStack stack ){
   Node* start = first;
//START OF THE LINKED LIST
if (start == nullptr){
    first = new Node (stack);
    last = first;
    occupied++;
    return true;
//LOOKS FOR MATCHING
while ((start!=nullptr)&& (start->data!=stack)){
    start = start->next;
}
if (start ==nullptr && occupied != slots){
    last->next = new Node ( stack );
    last = last->next;
    occupied++;
    return true;
}

}


   }

/*

bool Inventory::addItems( ItemStack stack ){
    Node* it = first;

    // Add the first item stack
    if( it == nullptr ){
        first = new Node( stack );
        last = first;
        occupied++;

        return true;
    }

    // search for a matching stack
    while( (it != nullptr) && (it->data != stack) ){
        it = it->next;
    }

    if( it == nullptr && occupied != slots ){
        last->next = new Node( stack );
        last = last->next;

        occupied++;

        return true;
    }

    if( it != nullptr ){
        (it->data).addItems( stack.size() );

        return true;
    }

    return false;
}*/

void Inventory::display( std::ostream &outs ) const{
    outs << " -Used " << occupied << " of " << slots << " slots" << "\n";

    for( Node *it = first; it!= nullptr; it = it->next ){
        outs << "  " << it->data << "\n";
    }
}
/*
void Inventory::display( std::ostream &outs ) const{
    outs << " -Used " << occupied << " of " << slots << " slots" << "\n";

    for( Node *it = first; it!= nullptr; it = it->next ){
        outs << "  " << it->data << "\n";
    }
}
*/
