package co.windly.bookstore.presentation.main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavOptions
import androidx.navigation.Navigation.findNavController
import co.windly.bookstore.R
import co.windly.bookstore.presentation.main.definition.DrawerItemIdentifier.Companion.ABOUT
import co.windly.bookstore.presentation.main.definition.DrawerItemIdentifier.Companion.BASKET
import co.windly.bookstore.presentation.main.definition.DrawerItemIdentifier.Companion.BOOKS
import co.windly.bookstore.presentation.main.definition.DrawerItemIdentifier.Companion.HOME
import co.windly.bookstore.presentation.main.definition.DrawerItemIdentifier.Companion.PROFILE
import co.windly.bookstore.presentation.main.definition.DrawerItemIdentifier.Companion.SETTINGS
import co.windly.bookstore.presentation.main.definition.DrawerItemIdentifier.DrawerItemIdentifierType
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.holder.BadgeStyle
import com.mikepenz.materialdrawer.holder.StringHolder
import com.mikepenz.materialdrawer.model.AbstractBadgeableDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IProfile
import kotlinx.android.synthetic.main.activity_main.toolbar


class MainActivity : AppCompatActivity(), Drawer.OnDrawerItemClickListener {

  //region Lifecycle

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // Content view.
    setContentView(R.layout.activity_main)

    // Handle Toolbar
    setSupportActionBar(toolbar)

    // Create account header.
    accountHeader = prepareAccountHeader(savedInstanceState)

    // Create the drawer.
    drawer = prepareDrawer(savedInstanceState)
    drawer?.onDrawerItemClickListener = this

    // Only set the active selection or active profile if we do not recreate the activity.
    if (savedInstanceState == null) {
      drawer?.setSelection(HOME.toLong(), false)
    }

    // Update basket badge.
    drawer?.updateBadge(BASKET.toLong(), StringHolder("0"))
  }

  override fun onSaveInstanceState(outState: Bundle) {
    var outState = outState

    // Add the values which need to be saved from the drawer to the bundle.
    outState = drawer!!.saveInstanceState(outState)

    // Add the values which need to be saved from the accountHeader to the bundle.
    outState = accountHeader!!.saveInstanceState(outState)
    super.onSaveInstanceState(outState)
  }

  override fun onBackPressed() {
    if (drawer != null && drawer!!.isDrawerOpen) {
      drawer!!.closeDrawer()
    } else {
      super.onBackPressed()
    }
  }

  //endregion

  //region Drawer

  private var drawer: Drawer? = null

  private fun prepareDrawer(savedInstanceState: Bundle?): Drawer {

    // Return drawer.
    return DrawerBuilder()
        .withActivity(this)
        .withToolbar(toolbar)
        .withHasStableIds(true)
        .withAccountHeader(accountHeader!!)
        .addDrawerItems(*prepareDrawerItems())
        .addStickyDrawerItems(*prepareStickyDrawerItems())
        .withSavedInstance(savedInstanceState)
        .withShowDrawerOnFirstLaunch(true)
        .build()
  }

  private fun materialize(item: AbstractBadgeableDrawerItem<*>): AbstractBadgeableDrawerItem<*> {
    return item
        .withTextColor(ContextCompat.getColor(this, R.color.black))
        .withIconColor(ContextCompat.getColor(this, R.color.black))
        .withSelectedTextColor(ContextCompat.getColor(this, R.color.primary))
        .withSelectedIconColor(ContextCompat.getColor(this, R.color.primary))
        .withDisabledTextColor(ContextCompat.getColor(this, R.color.black))
  }

  private fun prepareDrawerItems(): Array<IDrawerItem<*, *>> {
    return arrayOf(

        // Prepare home item.
        materialize(
            PrimaryDrawerItem()
                .withName(R.string.drawer_item_home)
                .withIcon(R.drawable.ic_home)
                .withIconTintingEnabled(true)
                .withIdentifier(HOME.toLong())),

        // Prepare books item.
        materialize(
            PrimaryDrawerItem()
                .withName(R.string.drawer_item_books)
                .withIcon(R.drawable.ic_books)
                .withIconTintingEnabled(true)
                .withIdentifier(BOOKS.toLong())),

        // Prepare basket item with badge.
        materialize(
            PrimaryDrawerItem()
                .withName(R.string.drawer_item_basket)
                .withIcon(R.drawable.ic_basket)
                .withIconTintingEnabled(true)
                .withIdentifier(BASKET.toLong())
                .withBadgeStyle(
                    BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.md_red_700)))
    )
  }

  private fun prepareStickyDrawerItems(): Array<IDrawerItem<*, *>> {
    return arrayOf(

        // Prepare settings item.
        materialize(
            SecondaryDrawerItem()
                .withName(R.string.drawer_item_settings)
                .withIcon(R.drawable.ic_settings)
                .withIconTintingEnabled(true)
                .withIdentifier(SETTINGS.toLong())),

        // Prepare about item.
        materialize(
            SecondaryDrawerItem()
                .withName(R.string.drawer_item_about)
                .withIcon(R.drawable.ic_about)
                .withIconTintingEnabled(true)
                .withIdentifier(ABOUT.toLong()))
    )
  }

  override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*, *>?): Boolean {
    val identifier = drawerItem?.identifier
    identifier?.toInt()?.let { handleMenuItemClicked(it) }
    return false
  }

  private fun handleMenuItemClicked(@DrawerItemIdentifierType section: Int) {
    when (section) {
      HOME -> navigateToHomeView()
      BOOKS -> navigateToBooksView()
      BASKET -> navigateToBasketView()
      SETTINGS -> navigateToSettingsView()
      ABOUT -> navigateToAboutView()
      else -> {
        // Nothing to do.
      }
    }
  }

  //endregion

  //region Account Header

  private var accountHeader: AccountHeader? = null

  private fun prepareAccountHeader(savedInstanceState: Bundle?): AccountHeader {

    // Return account header.
    return AccountHeaderBuilder()
        .withActivity(this)
        .withCompactStyle(false)
        .withProfileImagesClickable(false)
        .withSelectionListEnabledForSingleProfile(false)
        .addProfiles(*prepareProfiles("Adrian Zalewski", "adrianzalewski03@gmail.com"))
        .withSavedInstance(savedInstanceState)
        .build()
  }

  private fun prepareProfiles(name: String?, email: String?): Array<IProfile<*>> {
    return arrayOf(

        // Prepare profile item.
        ProfileDrawerItem()
            .withName(name)
            .withEmail(email)
            .withIcon(R.drawable.profile)
            .withIdentifier(PROFILE.toLong())
    )
  }

  //endregion

  //region Navigation

  private fun navOptions(): NavOptions? {

    // Create nav options.
    return NavOptions
        .Builder()
        .setPopUpTo(R.id.home, false)
        .build()
  }

  private fun navigateToDestination(@IdRes destinationId: Int) {

    // Find controller and navigate to destination using nav options.
    findNavController(this, R.id.mainHostFragment)
        .navigate(destinationId, null, navOptions())
  }

  private fun navigateToHomeView() {

    // Navigate to home view.
    navigateToDestination(R.id.home)
  }

  private fun navigateToBooksView() {

    // Navigate to books view.
    navigateToDestination(R.id.books)
  }

  private fun navigateToBasketView() {

    // Navigate to basket view.
    navigateToDestination(R.id.basket)
  }

  private fun navigateToSettingsView() {

    // Navigate to settings view.
    navigateToDestination(R.id.settings)
  }

  private fun navigateToAboutView() {

    // Navigate to about view.
    navigateToDestination(R.id.about)
  }

  //endregion
}