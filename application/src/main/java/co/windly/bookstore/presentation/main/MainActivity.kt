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
import com.afollestad.materialdialogs.MaterialDialog
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

    // Initialize toolbar.
    setSupportActionBar(toolbar)

    // Create account header.
    accountHeader = prepareAccountHeader(savedInstanceState)

    // Create the drawer.
    drawer = prepareDrawer(savedInstanceState)

    // Configure drawer listener.
    drawer?.onDrawerItemClickListener = this

    // Only set the active selection or active profile if we do not recreate the activity.
    if (savedInstanceState == null) {
      drawer?.setSelection(MainMenuItem.HOME, false)
    }

    // Update cart badge.
    drawer?.updateBadge(MainMenuItem.BASKET, StringHolder("0"))
  }

  override fun onSaveInstanceState(outState: Bundle) {

    // Add the values which need to be saved from the drawer to the bundle.
    var updated = drawer?.saveInstanceState(outState)

    // Add the values which need to be saved from the accountHeader to the bundle.
    updated = accountHeader?.saveInstanceState(updated)

    super.onSaveInstanceState(updated)
  }

  override fun onBackPressed() {
    drawer?.let {

      // In case if drawer is open - close it.
      if (it.isDrawerOpen) {
        it.closeDrawer()
      } else {

          with(findNavController(this, R.id.mainHostFragment)) {

              // Retrieve start destination id.
              val homeDestinationIdentifier = graph.startDestination

              // Retrieve current destination id.
              val currentDestinationIdentifier = currentDestination?.id

              // When we've got home destination id then show exit confirmation dialog - otherwise just follow the orders of supertype.
              when (homeDestinationIdentifier) {
                  currentDestinationIdentifier -> {

                      // Show confirmation dialog.
                      showConfirmExitDialog()
                  }
                  else -> super.onBackPressed()
              }
          }
      }
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

    // Materialize item.
    return item
        .withTextColor(ContextCompat.getColor(this, R.color.black))
        .withIconColor(ContextCompat.getColor(this, R.color.black))
        .withSelectedTextColor(ContextCompat.getColor(this, R.color.colorPrimary))
        .withSelectedIconColor(ContextCompat.getColor(this, R.color.colorPrimary))
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
                .withIdentifier(MainMenuItem.HOME)
        ),

        // Prepare books item.
        materialize(
            PrimaryDrawerItem()
                .withName(R.string.drawer_item_book_list)
                .withIcon(R.drawable.ic_books)
                .withIconTintingEnabled(true)
                .withIdentifier(MainMenuItem.BOOKS)
        ),

        // Prepare basket item with badge.
        materialize(
            PrimaryDrawerItem()
                .withName(R.string.drawer_item_cart)
                .withIcon(R.drawable.ic_basket)
                .withIconTintingEnabled(true)
                .withIdentifier(MainMenuItem.BASKET)
                .withBadgeStyle(
                    BadgeStyle()
                        .withTextColor(Color.WHITE)
                        .withColorRes(R.color.colorAccent)
                )
        )
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
                .withIdentifier(MainMenuItem.SETTINGS)
        ),

        // Prepare about item.
        materialize(
            SecondaryDrawerItem()
                .withName(R.string.drawer_item_about)
                .withIcon(R.drawable.ic_about)
                .withIconTintingEnabled(true)
                .withIdentifier(MainMenuItem.ABOUT)
        )
    )
  }

  override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*, *>?): Boolean {

    // Handle menu item click.
    return drawerItem?.identifier?.let { handleMenuItemClicked(it) }.let { false }
  }

  private fun handleMenuItemClicked(@MainMenuItem.Definition section: Long) {
    when (section) {
      MainMenuItem.HOME -> navigateToHomeView()
      MainMenuItem.BOOKS -> navigateToBooksView()
      MainMenuItem.BASKET -> navigateToBasketView()
      MainMenuItem.SETTINGS -> navigateToSettingsView()
      MainMenuItem.ABOUT -> navigateToAboutView()
      else -> {
        // Nothing to do.
      }
    }
  }

  //endregion

  //region Account Header

  private var accountHeader: AccountHeader? = null

  private fun prepareAccountHeader(savedInstanceState: Bundle?): AccountHeader {

    // TODO: Retrieve user details.
    val username = "John Snow"
    val email = "john.snow@winterfell.com"

    // Return account header.
    return AccountHeaderBuilder()
        .withActivity(this)
        .withCompactStyle(false)
        .withProfileImagesClickable(false)
        .withSelectionListEnabledForSingleProfile(false)
        .addProfiles(*prepareProfiles(username, email))
        .withSavedInstance(savedInstanceState)
        .build()
  }

  private fun prepareProfiles(name: String?, email: String?): Array<IProfile<*>> {

    // Prepare profile item.
    return arrayOf(
        ProfileDrawerItem()
            .withName(name)
            .withEmail(email)
            .withIcon(R.drawable.ic_avatar_male)
            .withIdentifier(MainMenuItem.PROFILE)
    )
  }

  //endregion

  //region Navigation

  private fun navOptions(inclusive: Boolean): NavOptions? {

    // Create nav options.
    return NavOptions
        .Builder()
        .setPopUpTo(R.id.home, inclusive)
        .build()
  }

  private fun navigateToDestination(@IdRes destinationId: Int, inclusive: Boolean) {

    // Find controller and navigate to destination using nav options.
    findNavController(this, R.id.mainHostFragment)
        .navigate(destinationId, null, navOptions(inclusive))
  }

  private fun navigateToHomeView() {

    // Navigate to home view.
    navigateToDestination(R.id.home, true)
  }

  private fun navigateToBooksView() {

    // Navigate to books view.
    navigateToDestination(R.id.books, false)
  }

  private fun navigateToBasketView() {

    // Navigate to basket view.
    navigateToDestination(R.id.cart, false)
  }

  private fun navigateToSettingsView() {

    // Navigate to settings view.
    navigateToDestination(R.id.settings, false)
  }

  private fun navigateToAboutView() {

    // Navigate to about view.
    navigateToDestination(R.id.about, false)
  }

  //endregion

  //region Dialogs

  private fun showConfirmExitDialog() {

    // Show confirmation exit dialog.
    MaterialDialog(this)
        .message(R.string.home_dialog_confirm_logout)
        .positiveButton(R.string.common_yes)
        .negativeButton(R.string.common_no)
        .positiveButton { closeApplication() }
        .show()
  }

  //endregion

  //region Close Application

  private fun closeApplication() {

    // Close application.
    finish()
  }

  //endregion
}
