package com.aimicor.navcompose.typesafe.examples.feature.videorails.presentation.state;

import com.aimicor.navcompose.typesafe.examples.feature.FetchVideoRailsUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class VideoRailsViewModel_Factory implements Factory<VideoRailsViewModel> {
  private final Provider<FetchVideoRailsUseCase> homeUseCaseProvider;

  public VideoRailsViewModel_Factory(Provider<FetchVideoRailsUseCase> homeUseCaseProvider) {
    this.homeUseCaseProvider = homeUseCaseProvider;
  }

  @Override
  public VideoRailsViewModel get() {
    return newInstance(homeUseCaseProvider.get());
  }

  public static VideoRailsViewModel_Factory create(
      Provider<FetchVideoRailsUseCase> homeUseCaseProvider) {
    return new VideoRailsViewModel_Factory(homeUseCaseProvider);
  }

  public static VideoRailsViewModel newInstance(FetchVideoRailsUseCase homeUseCase) {
    return new VideoRailsViewModel(homeUseCase);
  }
}
