package com.example.nutriforagepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nutriforagepractice.recipes.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AllRecipes extends AppCompatActivity {

    RecyclerView myrecyclerView;
    RecyclerViewAdapter myAdapter;

    List<Recipes> recipes1;
    ImageView backBtnRecipes1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_recipes);

        recipes1 = new ArrayList<>();
        recipes1.add(new Recipes("Herbed Chicken Marsala",
                "\n\u2022 Four 4-ounce boneless, skinless chicken breast cutlets\n" +
                "\n\u2022 Kosher salt and freshly ground black pepper\n" +
                "\n\u2022 1/3 cup whole wheat flour\n"+
                "\n\u2022 1 1/2 tablespoons extra-virgin olive oil\n" +
                "\n\u2022 3/4 cup low-sodium chicken broth\n" +
                "\n\u2022 1/3 cup sun-dried tomatoes (not packed in oil; not rehydrated), finely chopped or very thinly sliced\n" +
                "\n\u2022 1/2 teaspoon finely chopped rosemary\n" +
                "\n\u2022 10 ounces white button or cremini (baby bella) mushrooms, sliced\n" +
                "\n\u2022 1/3 cup sweet marsala wine\n" +
                "\n\u2022 2 teaspoons unsalted butter\n" +
                "\n\u2022 1 to 2 tablespoons roughly chopped flat-leaf parsley\n","Method",
                "\n\u2022 Place the chicken cutlets between 2 pieces of plastic wrap and pound with a meat mallet (or the flat side of a chef's knife) until about 1/3-inch thick. Sprinkle with 1/4 teaspoon salt and 1/4 teaspoon pepper.\n \n"
                + "\u2022 Put the flour on a medium plate. Heat the oil in a large nonstick skillet over medium-high heat. Dredge the chicken in the flour to fully coat, shaking off any excess. Add the chicken to the skillet and fry until fully cooked and golden brown, about 4 minutes per side. Transfer to a platter and tent with foil to keep warm.\n \n"
                + "\u2022 Add 1/2 cup of the broth, the sun-dried tomatoes and rosemary to any remaining drippings in the skillet and cook, stirring frequently, for 1 minute to plump the tomatoes. Add the mushrooms, 1/4 teaspoon salt and 1/2 teaspoon pepper and cook until the mushrooms are soft, about 5 minutes. Add the marsala and bring to a boil. Add the remaining 1/4 cup broth and the butter and simmer until the butter is fully melted, about 30 seconds.\n \n"
                + "\u2022 Spoon the mushroom mixture and sauce over the chicken, sprinkle with the parsley and serve.\n", R.drawable.r_herbed_chicken_marsala));

        recipes1.add(new Recipes("Sloppy Joes",
                "\n\u2022 1 pound extra-lean ground beef\n" +
                        "\n\u2022 1 onion, diced\n" +
                        "\n\u2022 4 cloves garlic, minced\n"+
                        "\n\u2022 1 jalapeno, minced\n" +
                        "\n\u2022 1 red pepper, diced\n" +
                        "\n\u2022 1 can small red beans or pinto beans, preferably low sodium drained and rinsed\n" +
                        "\n\u2022 1 1/2 cups no-salt-added tomato sauce\n" +
                        "\n\u2022 2 tablespoons tomato paste\n" +
                        "\n\u2022 1 tablespoon red wine vinegar\n" +
                        "\n\u2022 1 tablespoon Worcestershire sauce\n" +
                        "\n\u2022 1 teaspoon mustard powder\n" +
                        "\n\u2022 3/4 teaspoon salt\n" +
                        "\n\u2022 Freshly ground black pepper\n" +
                        "\n\u2022 8 whole-wheat burger buns\n","Method",
                "\n\u2022 Brown the meat and the onion in a large nonstick skillet over medium-high heat for 5 minutes, breaking up the meat into crumbles as it cooks.\n \n"
                        + "\u2022 Pour the drippings out of the pan and discard. Add the garlic, jalapeno, and red pepper and cook 5 minutes more, stirring occasionally.\n \n"
                        + "\u2022 Stir in the rest of the ingredients, reduce heat to low, and simmer for 5 minutes more.\n \n"
                        + "\u2022 Place a half-cup scoop of the mixture onto each bun and serve.\n", R.drawable.r_sloppy_joes));

        recipes1.add(new Recipes("Pan-Seared Salmon with Kale and Apple Salad",
                "\n\u2022 Four 5-ounce center-cut salmon fillets (about 1-inch thick) \n" +
                        "\n\u2022 3 tablespoons fresh lemon juice \n" +
                        "\n\u2022 3 tablespoons olive oil \n"+
                        "\n\u2022 Kosher salt \n" +
                        "\n\u2022 1 bunch kale, ribs removed, leaves very thinly sliced (about 6 cups)\n" +
                        "\n\u2022 1/4 cup dates\n" +
                        "\n\u2022 1 Honeycrisp apple\n" +
                        "\n\u2022 1/4 cup finely grated pecorino\n" +
                        "\n\u2022 3 tablespoons toasted slivered almonds\n" +
                        "\n\u2022 Freshly ground black pepper\n" +
                        "\n\u2022 4 whole wheat dinner rolls\n","Method",
                "\n\u2022 Bring the salmon to room temperature 10 minutes before cooking.\n \n"
                        + "\u2022 Meanwhile, whisk together the lemon juice, 2 tablespoons of the olive oil and 1/4 teaspoon salt in a large bowl. Add the kale, toss to coat and let stand 10 minutes. \n"
                        + "\u2022 While the kale stands, cut the dates into thin slivers and the apple into matchsticks. Add the dates, apples, cheese and almonds to the kale. Season with pepper, toss well and set aside.\n \n"
                        + "\u2022 Sprinkle the salmon all over with 1/2 teaspoon salt and some pepper. Heat the remaining 1 tablespoon oil in a large nonstick skillet over medium-low heat. Raise the heat to medium-high. Place the salmon, skin-side up in the pan. Cook until golden brown on one side, about 4 minutes. Turn the fish over with a spatula, and cook until it feels firm to the touch, about 3 minutes more.\n \n"
                        + "\u2022 Divide the salmon, salad and rolls evenly among four plates.\n", R.drawable.r_pan_seared_salmon));

        recipes1.add(new Recipes("Lemony Yogurt Pound Cake",
                "\n\u2022 Nonstick baking spray, for coating loaf pan\n" +
                        "\n\u2022 1 1/2 cups white whole wheat flour\n" +
                        "\n\u2022 2 teaspoons baking powder\n"+
                        "\n\u2022 1/4 teaspoon fine salt\n" +
                        "\n\u2022 3/4 cup sugar\n" +
                        "\n\u2022 Finely grated zest of 1 lemon\n" +
                        "\n\u2022 1/2 cup plain lowfat (2-percent) Greek yogurt\n" +
                        "\n\u2022 1/4 cup lowfat (1-percent) milk\n" +
                        "\n\u2022 1/4 cup extra-virgin olive oil\n" +
                        "\n\u2022 1/2 teaspoon pure vanilla extract\n" +
                        "\n\u2022 2 large egg whites\n" +
                        "\n\u2022 1 large egg\n","Method",
                "\n\u2022 Preheat the oven to 350 degrees F. Coat an 8 1/2- by 4 1/2-inch loaf pan with baking spray.\n \n"
                        + "\u2022 Whisk together the flour, baking powder and salt in a medium bowl. Put the sugar and lemon zest in another bowl and rub the lemon zest into the sugar with your fingers.\n \n"
                        + "\u2022 Add the yogurt, milk, olive oil, vanilla, egg whites and whole egg and vigorously whisk until well blended.\n \n"
                        + "\u2022 Add the flour mixture into the egg mixture and fold until just incorporated. Transfer to the prepared pan.\n \n"
                        + "\u2022 Bake until a cake tester inserted in the center comes out clean, about 50 minutes. Cool in the pan on a wire rack for 5 minutes, and then unmold and cool to room temperature.\n", R.drawable.r_lemony));

        recipes1.add(new Recipes("Healthy Air Fryer Parmesan Chicken with Broccoli",
                "\n\u2022 1/3 cup panko\n" +
                        "\n\u2022 1/4 cup finely grated Parmesan\n" +
                        "\n\u2022 4 teaspoons olive oil\n"+
                        "\n\u2022 1/2 teaspoon dried oregano\n" +
                        "\n\u2022 Kosher salt and freshly ground black pepper\n" +
                        "\n\u2022 2 small boneless, skinless chicken breasts (about 6 ounces each)\n" +
                        "\n\u2022 1 1/2 tablespoons plus 1/4 teaspoon Dijon mustard\n" +
                        "\n\u2022 2 cups small broccoli florets (about 5 ounces)\n" +
                        "\n\u2022 1/4 cup low-fat plain yogurt\n" +
                        "\n\u2022 Finely grated zest and juice of 1/2 lemon\n","Method",
                "\n\u2022 Stir together the panko, Parmesan, 2 teaspoons of the olive oil, the oregano, pinch of salt and a couple grinds of pepper in a shallow bowl or small baking dish until thoroughly combined. Pat the chicken dry between a couple paper towels, then sprinkle lightly with salt and pepper. Brush both sides of the chicken with 1 1/2 tablespoons of the Dijon, then press into the panko-Parmesan mixture, making sure both sides are evenly coated.\n \n"
                        + "\u2022 Toss the broccoli, remaining 2 teaspoons of the olive oil, a good pinch of salt and several grinds of pepper in a medium bowl until evenly coated. \n \n"
                        + "\u2022 Preheat a 3.5-quart air fryer to 375 degrees F. Add the chicken to the air-fryer basket and cook until it’s starting to brown and crisp on the top, about 6 minutes. Flip the chicken over with tongs and position in the center of the basket, then scatter the broccoli around the perimeter. Continue air-frying until the chicken is crisp all over and an instant-read thermometer inserted in the middle registers 160 degrees F, and the broccoli is tender and charred, about 8 minutes more.\n \n"
                        + "\u2022 Meanwhile, stir together the yogurt, lemon zest and juice, remaining 1/4 teaspoon Dijon, a pinch of salt and several grinds of pepper in a small bowl. Serve alongside the chicken and broccoli for dipping. \n", R.drawable.r_chicken_broc));

        recipes1.add(new Recipes("Mixed Berries and Banana Smoothie (and Smoothie Bowl)",
                "\n\u2022 1 cup frozen mixed berries\n" +
                        "\n\u2022 3/4 cup orange juice\n" +
                        "\n\u2022 1/4 cup low-fat vanilla yogurt\n"+
                        "\n\u2022 1 frozen ripe banana\n" +
                        "\n\u2022 1 teaspoon honey, optional\n" +
                        "\n\u2022 1/4 cup fresh blueberries\n" +
                        "\n\u2022 1/4 cup fresh raspberries\n" +
                        "\n\u2022 2 dollops low-fat vanilla yogurt\n" +
                        "\n\u2022 2 to 3 tablespoons granola\n" +
                        "\n\u2022 1 teaspoon chia seeds\n","Method",
                "\n\u2022 For the smoothie: Combine the berries, orange juice, yogurt, banana and honey, if using, in a blender and puree until smooth.\n \n"
                        + "\u2022 For the toppings: Pour the smoothie into a bowl. Top with the blueberries, raspberries, vanilla yogurt and granola. Sprinkle with the chia seeds.\n", R.drawable.r_mixed_berries_smoothie));

        recipes1.add(new Recipes("Breakfast Casserole",
                "\n\u2022 8 ounces spicy or sweet turkey sausage links, casings removed, meat crumbled\n" +
                        "\n\u2022 2 scallions, sliced\n" +
                        "\n\u2022 6 large eggs and 6 large egg whites\n"+
                        "\n\u2022 1 3/4 cups 1-percent milk\n" +
                        "\n\u2022 Kosher salt and freshly ground black pepper\n" +
                        "\n\u2022 One 9-ounce package frozen chopped spinach, thawed and drained of excess liquid \n" +
                        "\n\u2022 3/4 cup shredded Cheddar\n" +
                        "\n\u2022 1/2 cup grated Parmesan\n" +
                        "\n\u2022 1/2 whole wheat baguette, cut into 3/4-inch cubes (about 4 cups)\n" +
                        "\n\u2022 Cooking spray\n","Method",
                "\n\u2022 Heat a large nonstick skillet over medium heat. Add the turkey and scallions and cook, stirring to break up any large chunks, until browned and cooked through, about 10 minutes. Remove from heat and let cool slightly.\n \n"
                        + "\u2022 Whisk the eggs, egg whites, milk and 1/2 teaspoon each salt and pepper in a large bowl until combined. Add the cooked sausage, spinach, cheeses and bread and toss to distribute the ingredients evenly.\n \n"
                        + "\u2022 Spray a 3-quart casserole dish with cooking spray. Spread the egg mixture evenly in the dish. Cover and refrigerate for at least 6 hours or preferably overnight.\n \n"
                        + "\u2022 Preheat the oven to 350 degrees F. Bake the casserole, uncovered, until set and lightly browned on top, about 30 minutes.\n", R.drawable.r_breakfast_casserole));

        recipes1.add(new Recipes("Broiled Salmon with Herb Mustard Glaze",
                "\n\u2022 2 garlic cloves\n" +
                        "\n\u2022 3/4 teaspoon finely chopped fresh rosemary leaves\n" +
                        "\n\u2022 3/4 teaspoon finely chopped fresh thyme leaves \n"+
                        "\n\u2022 1 tablespoon dry white wine\n" +
                        "\n\u2022 1 tablespoon extra-virgin olive oil\n" +
                        "\n\u2022 2 tablespoons Dijon mustard\n" +
                        "\n\u2022 2 tablespoons whole-grain mustard\n" +
                        "\n\u2022 Nonstick olive oil cooking spray\n" +
                        "\n\u2022 Six 6- to 8-ounce salmon fillets\n" +
                        "\n\u2022 Salt and freshly ground black pepper \n" +
                        "\n\u2022 6 lemon wedges\n","Method",
                "\n\u2022 In a mini food processor, combine garlic, rosemary, thyme, wine, oil, Dijon mustard, and 1 tablespoon of whole-grain mustard. Grind the mustard sauce until combined, about 30 seconds. Transfer to a small bowl. Add remaining 1 tablespoon of whole-grain mustard to the sauce and stir to combine. Set aside mustard sauce.\n \n"
                        + "\u2022 Preheat the broiler. Line a heavy rimmed baking sheet with foil. Spray the foil with nonstick spray. Arrange the salmon fillets on the baking sheet and sprinkle them with salt and pepper. Broil for 2 minutes. Spoon the mustard sauce over the fillets. Continue broiling until the fillets are just cooked through and golden brown, about 5 minutes longer.\n \n"
                        + "\u2022 Transfer the fillets to plates and serve with lemon wedges.\n", R.drawable.r_broiled_salmon));

        recipes1.add(new Recipes("Whole30 Bacon and Egg Cups",
                "\n\u2022 12 strips sugar-free bacon (about 10 ounces)\n" +
                        "\n\u2022 2 red potatoes, sliced 1/8 inch thick, rounded ends discarded\n" +
                        "\n\u2022 1 small red bell pepper, finely chopped\n"+
                        "\n\u2022 12 large eggs\n" +
                        "\n\u2022 2 tablespoons chopped fresh chives\n" +
                        "\n\u2022 Hot sauce, for serving\n","Method",
                "\n\u2022 Preheat the oven to 400 degrees F. Wrap 1 piece of bacon around the inside of each cup of a 12-cup muffin tin to create rings. Put 1 slice of potato on the bottom of each cup and divide the bell pepper pieces among the cups.\n \n"
                        + "\u2022 Bake until the fat starts to render from the bacon (it will bubble in the bottom of each cup) and the bacon begins to crisp and turn light brown on the top edges, 10 to 12 minutes. \n \n"
                        + "\u2022 Remove the tin from the oven and crack an egg into each cup, making sure the yolk is inside the bacon ring. Continue baking until the bacon is crisp, the egg whites are cooked through and the yolks are still runny, about 10 minutes longer. Run an offset spatula around the edges and remove to a platter. Sprinkle with the chives and serve with hot sauce if desired. \n", R.drawable.r_bacon_egg_cups));

        recipes1.add(new Recipes("Slow-Cooker Pork Tacos",
                "\n\u2022 3 whole ancho chiles\n" +
                        "\n\u2022 3 whole pasilla chiles\n" +
                        "\n\u2022 4 cloves garlic, unpeeled\n"+
                        "\n\u2022 2 to 3 chipotles in adobo sauce\n" +
                        "\n\u2022 1/2 medium white onion, roughly chopped\n" +
                        "\n\u2022 3 tablespoons extra-virgin olive oil\n" +
                        "\n\u2022 2 tablespoons honey\n" +
                        "\n\u2022 1 tablespoon cider vinegar\n" +
                        "\n\u2022 Kosher salt\n" +
                        "\n\u2022 2 teaspoons dried oregano, preferably Mexican\n" +
                        "\n\u2022 3 3/4 cups low-sodium chicken broth\n" +
                        "\n\u2022 4 pounds boneless pork shoulder (untrimmed), cut into chunks\n" +
                        "\n\u2022 Freshly ground pepper\n" +
                        "\n\u2022 2 bay leaves\n" +
                        "\n\u2022 1 cinnamon stick\n" +
                        "\n\u2022 Corn tortillas, warmed, for serving\n" +
                        "\n\u2022 Assorted taco toppings, for garnish\n","Method",
                "\n\u2022 Put the ancho and pasilla chiles and the garlic in a bowl; add 2 to 3 tablespoons water. Microwave on high until soft and pliable, 2 to 3 minutes. Stem and seed the chiles; peel the garlic. Transfer the chiles and garlic to a blender.\n \n"
                        + "\u2022 Add the chipotles, onion, 2 tablespoons olive oil, honey, vinegar, 1 tablespoon salt and the oregano to the blender; puree until smooth. Heat the remaining 1 tablespoon oil in a large skillet over high heat; add the chile sauce and fry, stirring, until thick and fragrant, about 8 minutes. Pour in the broth and reduce until slightly thickened.\n \n"
                        + "\u2022 Season the pork all over with salt and pepper and transfer to a large slow cooker. Add the bay leaves and cinnamon stick, then pour in the sauce. Cover and cook on high until the meat is tender, about 5 hours. (Or cook the meat in a large Dutch oven, covered, for 1 hour 45 minutes at 350 degrees; uncover and cook 30 more minutes.)\n \n"
                        + "\u2022 Discard the bay leaves and cinnamon stick. Shred the pork with 2 forks; season with salt and pepper. Serve the shredded pork in the tortillas, along with toppings.\n", R.drawable.r_pork_tacos));

        recipes1.add(new Recipes("Vegetable Noodle Soup",
                "\n\u2022 2 tablespoons extra-virgin olive oil\n" +
                        "\n\u2022 1 rib celery, sliced (about 1 cup)\n" +
                        "\n\u2022 1 medium carrot, sliced (about 3/4 cup)\n"+
                        "\n\u2022 1 clove garlic, smashed\n" +
                        "\n\u2022 1/4 medium onion, about 1/2 cup\n" +
                        "\n\u2022 1/4 teaspoon kosher salt\n" +
                        "\n\u2022 1/3 cup orzo or other small pasta or egg noodles or broken up spaghetti\n" +
                        "\n\u2022 4 cups low-sodium chicken broth (1-quart box, or 2 cans)\n" +
                        "\n\u2022 Small handful fresh parsley leaves, basil or dill, chopped (about 2 tablespoons)\n" +
                        "\n\u2022 1/2 lemon, juiced (about 1 tablespoon)\n" +
                        "\n\u2022 Freshly ground black pepper\n" +
                        "\n\u2022 Serving suggestion: Whole-wheat crackers and cheese sticks.\n","Method",
                "\n\u2022 Heat the olive oil in a medium saucepan over medium heat; add all the vegetables, garlic and onion. Season with the salt, and cook until tender, about 6 minutes. Add the pasta and cook until slightly toasted and golden, about 2 minutes. Add broth, and bring to a boil over high heat. Cook, covered, until pasta is just tender, about 8 minutes.\n \n"
                        + "\u2022 Stir in whatever herb suits you (or your young eater) and lemon juice. Season with pepper and additional salt, to taste. Fill thermos, pack in a lunch sack with crackers and cheese sticks and send off to school.\n \n"
                        + "\u2022 This soup freezes well, so freeze any leftovers or make a double batch to have plenty on hand. Also, you can stir in some cooked chicken or mini-meatballs, if desired, for another meal.\n", R.drawable.r_veg_noodle_soup));


        recipes1.add(new Recipes("Angel Food Cake",
                "\n\u2022 1 3/4 cups sugar\n" +
                        "\n\u2022 1/4 teaspoon salt\n" +
                        "\n\u2022 1 cup cake flour, sifted\n"+
                        "\n\u2022 12 egg whites (the closer to room temperature the better)\n" +
                        "\n\u2022 1/3 cup warm water\n" +
                        "\n\u2022 1 teaspoon orange extract, or extract of your choice\n" +
                        "\n\u2022 1 1/2 teaspoons cream of tartar\n","Method",
                "\n\u2022 Preheat oven to 350 degrees F.\n \n"
                        + "\u2022 In a food processor spin sugar about 2 minutes until it is superfine. Sift half of the sugar with the salt the cake flour, setting the remaining sugar aside.\n \n"
                        + "\u2022 In a large bowl, use a balloon whisk to thoroughly combine egg whites, water, orange extract, and cream of tartar. After 2 minutes, switch to a hand mixer. Slowly sift the reserved sugar, beating continuously at medium speed. Once you have achieved medium peaks, sift enough of the flour mixture in to dust the top of the foam. Using a spatula fold in gently. Continue until all of the flour mixture is incorporated.\n \n"
                        + "\u2022 Carefully spoon mixture into an ungreased tube pan. Bake for 35 minutes before checking for doneness with a wooden skewer. (When inserted halfway between the inner and outer wall, the skewer should come out dry).\n \n"
                        + "\u2022 Cool upside down on cooling rack for at least an hour before removing from pan.\n", R.drawable.r_angel_food_cake));

        recipes1.add(new Recipes("Blueberry Compote",
                "\n\u2022 2 cups frozen blueberries\n" +
                        "\n\u2022 3 tablespoons water\n" +
                        "\n\u2022 1/4 cup sugar\n"+
                        "\n\u2022 2 teaspoons lemon juice\n","Method",
                "\n\u2022 Combine 1 cup of the blueberries, water, sugar and lemon juice in a small saucepan.\n \n"
                        + "\u2022 Cook over a medium heat for about 10 minutes.\n \n"
                        + "\u2022 Add the rest of the blueberries and cook for 8 minutes more, stirring frequently\n \n"
                        + "\u2022 Serve warm.\n", R.drawable.r_blueberry_compote));

        recipes1.add(new Recipes("Chicken Saltimbocca",
                "\n\u2022 6 (3-ounce) chicken cutlets, pounded to evenly flatten\n" +
                        "\n\u2022 Salt and freshly ground black pepper\n" +
                        "\n\u2022 6 paper-thin slices prosciutto\n"+
                        "\n\u2022 1 (10-ounce) box frozen chopped spinach, thawed\n"+
                        "\n\u2022 3 tablespoons olive oil\n"+
                        "\n\u2022 1/4 cup grated Parmesan\n"+
                        "\n\u2022 1 (14-ounce) can low-salt chicken broth\n"+
                        "\n\u2022 2 tablespoons fresh lemon juice\n","Method",
                "\n\u2022 Place the chicken cutlets flat on the work surface. Sprinkle the chicken with salt and pepper. Lay 1 slice of prosciutto atop each chicken cutlet.\n \n"
                        + "\u2022 Squeeze the frozen spinach to remove the excess water. Season the spinach with salt and pepper. In a small bowl, toss the spinach with 1 tablespoon of oil to coat.\n \n"
                        + "\u2022 Arrange an even, thin layer of spinach atop the prosciutto slices. Sprinkle the Parmesan evenly over each. Beginning at the short tapered end, roll up each chicken cutlet as for a jellyroll. Secure with a toothpick.\n \n"
                        + "\u2022 Heat the remaining 2 tablespoons of oil in a heavy large skillet over high heat. Add the chicken and cook just until golden brown, about 2 minutes per side. Add the chicken broth and lemon juice, and scrape the browned bits off the bottom of the pan with a wooden spoon.\n \n"
                        + "\u2022 Bring the liquid to a boil. Reduce the heat to medium. Cover and simmer until the chicken is just cooked through, about 8 to 10 minutes. Transfer the chicken to a platter. Simmer the cooking liquid over high heat until it is reduced to about 2/3 cup, about 5 minutes.\n \n"
                        + "\u2022 Season the cooking liquid with salt and pepper, to taste. Remove toothpicks from the chicken. Drizzle the reduced cooking liquid over the chicken and serve immediately.\n", R.drawable.r_chicken_saltimbocca));

        recipes1.add(new Recipes("Healthy Lentil Chili",
                "\n\u2022 1 tablespoon olive oil\n" +
                        "\n\u2022 1 large onion, diced\n" +
                        "\n\u2022 1 red, orange or yellow bell pepper, diced\n"+
                        "\n\u2022 4 cloves garlic, minced\n"+
                        "\n\u2022 Kosher salt and freshly ground black pepper\n"+
                        "\n\u2022 2 tablespoons tomato paste\n"+
                        "\n\u2022 2 tablespoons chili powder\n"+
                        "\n\u2022 1 1/2 teaspoons dried oregano\n"+
                        "\n\u2022 1/2 teaspoon ground cumin\n"+
                        "\n\u2022 4 cups low-sodium vegetable broth\n"+
                        "\n\u2022 Two 14.5-ounce cans fire-roasted diced tomatoes\n"+
                        "\n\u2022 One 15-ounce can navy beans or another small white bean (do not drain)\n"+
                        "\n\u2022 1 cup dried brown lentils\n"+
                        "\n\u2022 1 dried bay leaf\n"+
                        "\n\u2022 1 tablespoon red wine vinegar\n"+
                        "\n\u2022 Shredded reduced-fat Cheddar, plain yogurt, pickled jalapenos and crushed tortilla chips, for serving (all are optional)\n","Method",
                "\n\u2022 Heat the olive oil in a large pot or Dutch oven over medium-high heat until shimmering. Add the onion, bell pepper, garlic, 1/2 teaspoon salt and several grinds of black pepper. Cook until vegetables are just tender and browned in spots, stirring occasionally, about 6 minutes. Stir in the tomato paste, chili powder, oregano and cumin, then continue to cook until fragrant and brick-red in color, stirring frequently, about 2 minutes.\n \n"
                        + "\u2022 Stir in the vegetable broth, diced tomatoes, beans (and their liquid), lentils, bay leaf, 1/2 teaspoon salt and a couple grinds of black pepper. Bring to a steady simmer, then reduce the heat to medium-low. Partially cover with a lid and gently simmer, stirring occasionally, until the lentils are tender and the chili has thickened slightly, 35 to 45 minutes.  \n \n"
                        + "\u2022 Remove the bay leaf and stir in the vinegar. Season with salt and black pepper. Ladle into bowls and serve with toppings as desired. \n", R.drawable.r_lentil_chili));

        recipes1.add(new Recipes("Buffalo Cauliflower with Blue Cheese Sauce",
                "\n\u2022 1/3 cup nonfat sour cream\n" +
                        "\n\u2022 2 tablespoons crumbled blue cheese\n" +
                        "\n\u2022 1 tablespoon skim milk\n"+
                        "\n\u2022 2 teaspoons mayonnaise\n"+
                        "\n\u2022 Kosher salt and freshly ground black pepper\n"+
                        "\n\u2022 2 tablespoons unsalted butter\n"+
                        "\n\u2022 1/4 cup hot sauce, such as Frank's\n"+
                        "\n\u2022 1 tablespoon freshly squeezed lemon juice\n"+
                        "\n\u2022 2 tablespoons olive oil\n"+
                        "\n\u2022 Kosher salt\n"+
                        "\n\u2022 8 cups cauliflower florets (from about 1 medium head)\n","Method",
                "\n\u2022 Preheat the oven to 400 degrees F.\n \n"
                        + "\u2022 For the cheese sauce: Whisk together the sour cream, blue cheese, milk, mayonnaise, 1/8 teaspoon salt and a few grinds of pepper in a small bowl. Cover and refrigerate until chilled, about 30 minutes\n \n"
                        + "\u2022 For the Buffalo cauliflower: Meanwhile, microwave the butter in a small microwave-safe bowl on high until melted. Whisk in the hot sauce and lemon juice and set aside.\n \n"
                        + "\u2022 Mix olive oil, 1/4 teaspoon salt and 1/2 cup water in a large bowl. Add the cauliflower and toss until well coated. Spread the cauliflower on a rimmed baking sheet and roast until beginning to brown and just tender, 20 to 25 minutes. Whisk the hot sauce mixture again, drizzle over the cauliflower and toss with tongs to coat. Roast the cauliflower until the sauce is bubbling and browned around the edges, 5 to 7 minutes more. Serve hot with the cheese sauce.\n", R.drawable.r_buffalo_cauli));

        recipes1.add(new Recipes("Roasted Cauliflower and Broccoli",
                "\n\u2022 1 small head cauliflower (2 pounds), cut into florets\n" +
                        "\n\u2022 2 large stalks broccoli (1 pound), cut into florets\n" +
                        "\n\u2022 1 head garlic, broken into cloves\n"+
                        "\n\u2022 2 tablespoons olive oil\n"+
                        "\n\u2022 1/2 teaspoon salt\n","Method",
                "\n\u2022 Preheat the oven to 375 degrees F.\n \n"
                        + "\u2022 Place cauliflower and broccoli into a 9 by 13 inch baking dish, toss with the olive oil, and sprinkle with salt.\n \n"
                        + "\u2022 Cover the dish and bake for 1/2 hour. Remove the cover, stir and cook for 30 to 40 minutes more, until vegetables are tender and nicely browned, stirring occasionally.\n", R.drawable.r_roasted_cauli));

        recipes1.add(new Recipes("Tuscan Vegetable Soup",
                "\n\u2022 1 (15-ounce) can low-sodium canellini beans, drained and rinsed\n" +
                        "\n\u2022 1 tablespoon olive oil\n" +
                        "\n\u2022 1/2 large onion, diced (about 1 cup)\n"+
                        "\n\u2022 2 carrots, diced (about 1/2 cup)\n"+
                        "\n\u2022 2 stalks celery, diced, (about 1/2 cup)\n"+
                        "\n\u2022 1 small zucchini, diced (about 1 1/2 cups)\n"+
                        "\n\u2022 1 clove garlic, minced\n"+
                        "\n\u2022 1 tablespoon chopped fresh thyme leaves (or 1 teaspoon dried)\n"+
                        "\n\u2022 2 teaspoons chopped fresh sage leaves (or 1/2 teaspoon dried)\n"+
                        "\n\u2022 1/2 teaspoon salt\n"+
                        "\n\u2022 1/4 teaspoon freshly ground black pepper\n"+
                        "\n\u2022 32 ounces low-sodium chicken broth or vegetable broth\n"+
                        "\n\u2022 1 (14.5-ounce) can no salt added diced tomatoes\n"+
                        "\n\u2022 2 cups chopped baby spinach leaves\n"+
                        "\n\u2022 1/3 cup freshly grated Parmesan, optional\n","Method",
                "\n\u2022 In a small bowl mash half of the beans with a masher or the back of a spoon, and set aside.\n \n"
                        + "\u2022 Heat the oil in a large soup pot over medium-high heat. Add the onion, carrots, celery, zucchini, garlic, thyme, sage, 1/2 teaspoon of salt and 1/4 teaspoon of pepper, and cook stirring occasionally until the vegetables are tender, about 5 minutes.\n \n"
                        + "\u2022 Add the broth and tomatoes with the juice and bring to a boil. Add the mashed and whole beans and the spinach leaves and cook until the spinach is wilted, about 3 minutes more.\n \n"
                        + "\u2022 Serve topped with Parmesan, if desired.\n", R.drawable.r_tuscan_veg_soup));

        recipes1.add(new Recipes("Healthy Mediterranean Baked Haddock",
                "\n\u2022 Two 14-ounce cans cherry tomatoes\n" +
                        "\n\u2022 1/2 cup dry white wine\n" +
                        "\n\u2022 1/2 cup pitted Kalamata olives, sliced in half\n"+
                        "\n\u2022 4 cloves garlic, minced\n"+
                        "\n\u2022 2 tablespoons capers, drained\n"+
                        "\n\u2022 1 tablespoon honey\n"+
                        "\n\u2022 Kosher salt and freshly ground black pepper\n"+
                        "\n\u2022 Four 6-ounce haddock fillets, skin removed\n"+
                        "\n\u2022 1/2 teaspoon Italian seasoning\n"+
                        "\n\u2022 1/2 teaspoon sweet paprika\n"+
                        "\n\u2022 2 tablespoons olive oil\n"+
                        "\n\u2022 4 slices crusty bread\n","Method",
                "\n\u2022 Preheat the oven to 425 degrees F. Combine the cherry tomatoes, white wine, olives, 3 of the garlic cloves, capers, honey, 1/2 teaspoon salt and a few grinds of pepper in a 9-by-13-inch baking dish.\n \n"
                        + "\u2022 Pat the haddock fillets dry with a paper towel and season the flesh side with the Italian seasoning, paprika, 1 teaspoon salt and a few grinds of pepper. Nestle the fillets into the sauce in the baking dish. Bake until the sauce is bubbling around the edges and the fillets are cooked through and easily flaked with a fork, 15 to 20 minutes.  \n \n"
                        + "\u2022 Meanwhile, mix the remaining 1 garlic clove with the olive oil, 1/4 teaspoon salt and a few grinds of pepper in a small bowl. Brush both sides of each slice of bread with the oil mixture and place onto a baking sheet. Bake until the bread is toasted, 5 to 7 minutes.  \n \n"
                        + "\u2022 Serve the fish on plates with the sauce and bread on the side.\n", R.drawable.r_haddock));

        recipes1.add(new Recipes("Lemon-Garlic Shrimp and Grits",
                "\n\u2022 3/4 cup instant grits\n" +
                        "\n\u2022 Kosher salt and freshly ground black pepper\n" +
                        "\n\u2022 1/4 cup grated parmesan cheese\n"+
                        "\n\u2022 3 tablespoons unsalted butter\n"+
                        "\n\u2022 1 1/4 pounds medium shrimp, peeled and deveined (tails intact)\n"+
                        "\n\u2022 2 large cloves garlic, minced\n"+
                        "\n\u2022 Pinch of cayenne pepper (optional)\n"+
                        "\n\u2022 Juice of 1/2 lemon, plus wedges for serving\n"+
                        "\n\u2022 2 tablespoons roughly chopped fresh parsley\n","Method",
                "\n\u2022 Bring 3 cups water to a boil in a medium saucepan over high heat, covered. Uncover and slowly whisk in the grits, 1 teaspoon salt and 1/2 teaspoon black pepper. Reduce the heat to medium low and cook, stirring occasionally, until thickened, about 5 minutes.\n \n"
                        + "\u2022 Stir in the parmesan and 1 tablespoon butter. Remove from the heat and season with salt and black pepper. Cover to keep warm.\n \n"
                        + "\u2022 Meanwhile, season the shrimp with salt and black pepper. Melt the remaining 2 tablespoons butter in a large skillet over medium-high heat. Add the shrimp, garlic and cayenne, if using, and cook, tossing, until the shrimp are pink, 3 to 4 minutes.\n \n"
                        + "\u2022 Remove from the heat and add 2 tablespoons water, the lemon juice and parsley; stir to coat the shrimp with the sauce and season with salt and black pepper.\n \n"
                        + "\u2022 Divide the grits among shallow bowls and top with the shrimp and sauce. Serve with lemon wedges.\n", R.drawable.r_lemon_garlic_shrimp));

        recipes1.add(new Recipes("Healthier Adobo Recipe",
                "\n\u2022 1 cup apple cider vinegar\n" +
                        "\n\u2022 ½ cup low sodium soy sauce or coconut aminos\n" +
                        "\n\u2022 2 tbsp coconut sugar or brown sugar\n"+
                        "\n\u2022 6 cloves of garlic peeled and smashed\n"+
                        "\n\u2022 2 tsp black peppercorn\n"+
                        "\n\u2022 2 tsp freshly grated ginger\n"+
                        "\n\u2022 2 bay leaves\n"+
                        "\n\u2022 12 chicken drumsticks or 6 chicken legs \n"+
                        "\n\u2022 1 tablespoon refined coconut oil or avocado oil\n"+
                        "\n\u2022 1 cup low sodium chicken broth or water\n"+
                        "\n\u2022 4 cups cooked quinoa\n"+
                        "\n\u2022 2-3 cucumbers sliced diagonally\n"+
                        "\n\u2022 2 green onions chopped\n"+
                        "\n\u2022 2 teaspoons toasted sesame seeds\n","Method",
                "\n\u2022 Combine the marinade ingredients (up until the bay leaves) in a large glass bowl or a dish with a lid. Add the chicken and mix well. Cover and refrigerate for 2 hours or up to overnight (the longer the better).\n \n"
                        + "\u2022 If possible, give the chicken a stir from time to time to unsure it marinates equally. You can also transfer everything into a large freezer bag as that makes it easier to manipulate.\n \n"
                        + "\u2022 Heat oil over medium-high heat in a very large skillet. When the oil is hot, add the chicken to the pan (reserving the marinade) and brown it on all sides.\n \n"
                        + "\u2022 Stir in water/broth and reserved marinade and bring to a boil. Reduce heat; simmer, uncovered, until chicken is no longer pink and sauce is slightly reduced, 20-25 minutes. See notes if you’d like a thicker sauce.\n \n"
                        + "\u2022 Serve the chicken topped with cooking sauce, sesame seeds and green onions over a bed of quinoa and top with cucumber or your favorite bowl toppings.\n", R.drawable.adobo_img));

        recipes1.add(new Recipes("Gising-gising",
                "\n\u2022 1 lb green beans Baguio beans, chopped (about 3/4 inches)\n" +
                        "\n\u2022 1/2 lb ground pork\n" +
                        "\n\u2022 1 1/2 tablespoons shrimp paste\n"+
                        "\n\u2022 2 cups coconut milk\n"+
                        "\n\u2022 3 cloves garlic crushed\n"+
                        "\n\u2022 1 medium onion minced\n"+
                        "\n\u2022 2 tablespoons cooking oil\n"+
                        "\n\u2022 3 pieces chili chopped (optional)\n"+
                        "\n\u2022 1/2 teaspoon ground black pepper\n","Method",
                "\n\u2022 Heat oil in a pan\n \n"
                        + "\u2022 Sauté garlic and onion\n \n"
                        + "\u2022 Add pork. Cook for 3 to 5 minutes or until color turns medium brown.\n \n"
                        + "\u2022 Put-in ground black pepper, shrimp paste, and chili. Stir.\n \n"
                        + "\u2022 Pour-in coconut milk. Let boil and simmer for 20 minutes.\n \n"
                        + "\u2022 Add the green beans. Cook for 5 to 7 minutes while stirring gradually.\n \n"
                        + "\u2022 Turn off heat. Serve with white rice.\n \n"
                        + "\u2022 Share and enjoy!\n", R.drawable.gising_img));

        recipes1.add(new Recipes("Vegan Tinola",
                "\n\u2022 3 tablespoons cooking oil\n" +
                        "\n\u2022 5 garlic cloves, peeled, crushed, and minced\n" +
                        "\n\u2022 1 yellow onion, peeled and chopped\n"+
                        "\n\u2022 1 2-inch ginger, peeled and thinly sliced\n"+
                        "\n\u2022 1 small chayote/sayote, peeled and cut into wedges\n"+
                        "\n\u2022 ½ small young papaya peeled, deseeded, and cut into wedges\n"+
                        "\n\u2022 2 cups rice washing\n"+
                        "\n\u2022 4 cups water\n"+
                        "\n\u2022 1 cup button white mushrooms sliced, and/or\n"+
                        "\n\u2022 2½ pieces vegetable bouillon or 2 cups vegetable broth\n"+
                        "\n\u2022 1 extra firm tofu, cubed\n"+
                        "\n\u2022 few pinches sea salt\n","Method",
                "\n\u2022 Heat oil in a pan\n \n"
                        + "\u2022 Heat pot over medium heat and sauté garlic, onion, and ginger with oil until the onion has softened.\n \n"
                        + "\u2022 Add sayote, young papaya, rice washing, water, salt, and vegetable broth. Cook until the papaya and sayote have softened. Adjust seasoning to taste.\n \n"
                        + "\u2022 Mix in the mushrooms and tofu and cook for another minute or until the mushrooms have softened.\n \n"
                        + "\u2022 Add the spinach and cook for another minute.n \n"
                        + "\u2022 Turn off the heat and serve hot, preferably with rice on the side.\n", R.drawable.tofu_tinola_img));

        myrecyclerView = (RecyclerView)findViewById(R.id.recyclerView_id);

        myAdapter = new RecyclerViewAdapter(this,recipes1);

        myrecyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myrecyclerView.setAdapter(myAdapter);

        backBtnRecipes1 = findViewById(R.id.back_pressed_recipes1);

        backBtnRecipes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserDashboard.class);
                startActivity(intent);
                finish();

            }
        });



    }
}