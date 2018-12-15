#ifndef ARMOUR_H_INCLUDED
#define ARMOUR_H_INCLUDED

#include "Item.h"

/**
 * This class represents one piece of armour--as found in most video games. This includes
 * boots and helmets.
 *
 * Armour may not be stacked. All Constructors must initialize Item::stackable
 * to false.
 */
class Armour : public Item{
    private:

    protected:
        double durability;      ///< decreases each time the armour is used
        double defense;         ///< damage that is blocked
        std::string material;   ///< material out of which the armour is composed
        std::string modifier;   ///< one of protection, feather_falling, or unbreaking
        int modifer_level;      ///< modifier level in the range 1 to 3
        std::string element;    ///< associated element--e.g., ice, fire, and lightning.

    public:
        /**
         * Default to a armour with an empty name
         */
        Armour();

        ~Armour();

        /**
         * Copy Constructor
         */
        Armour( const Armour &src );


  virtual void display( std::ostream &outs ) const;
   virtual void read( std::istream& ins );
   virtual Item* clone() const;
};

#endif
